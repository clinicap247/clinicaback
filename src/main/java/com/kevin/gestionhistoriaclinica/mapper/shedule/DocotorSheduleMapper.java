package com.kevin.gestionhistoriaclinica.mapper.shedule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleResponse;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;
import com.kevin.gestionhistoriaclinica.util.time.TimeParser;

@Component
public class DocotorSheduleMapper {

        public DoctorShedule toEntity(DoctorSheduleStoreDto dto, int totalSlots, Doctor doctor, Speciality speciality,
                        ConsultingRoom consultingRoom) {
                return DoctorShedule.builder()
                                .dayOfWeek(dto.getDayOfWeek())
                                .startTime(TimeParser.parseTime(dto.getStartTime()))
                                .endTime(TimeParser.parseTime(dto.getEndTime()))
                                .slotDuration(dto.getSlotDuration())
                                .totalSlots(totalSlots)
                                .status(dto.getStatus())
                                .doctor(doctor)
                                .speciality(speciality)
                                .consultingRoom(consultingRoom)
                                .build();
        }

        public DoctorShedule updateEntityFromDto(DoctorSheduleUpdateDto dto, DoctorShedule doctorShedule,
                        int totalSlots,
                        Doctor doctor, Speciality speciality, ConsultingRoom consultingRoom) {
                doctorShedule.setId(dto.getId());
                doctorShedule.setDayOfWeek(dto.getDayOfWeek());
                doctorShedule.setStartTime(TimeParser.parseTime(dto.getStartTime()));
                doctorShedule.setEndTime(TimeParser.parseTime(dto.getEndTime()));
                doctorShedule.setTotalSlots(totalSlots);
                doctorShedule.setSlotDuration(dto.getSlotDuration());
                doctorShedule.setStatus(dto.getStatus());

                // Relations
                doctorShedule.setDoctor(doctor);
                doctorShedule.setSpeciality(speciality);
                doctorShedule.setConsultingRoom(consultingRoom);

                return doctorShedule;
        }

        public DoctorSheduleResponse toResponse(DoctorShedule doctorShedule) {
                // Obtener los números de slots reservados a partir de las citas (Appointments)
                List<Integer> reservedSlots = doctorShedule.getAppointments() != null
                                ? doctorShedule.getAppointments()
                                                .stream()
                                                .map(appointment -> appointment.getSlotNumber())
                                                .collect(Collectors.toList())
                                : Collections.emptyList();

                return DoctorSheduleResponse.builder()
                                .id(doctorShedule.getId())
                                .dayOfWeek(doctorShedule.getDayOfWeek())
                                .startTime(doctorShedule.getStartTime().toString())
                                .endTime(doctorShedule.getEndTime().toString())
                                .slotDuration(doctorShedule.getSlotDuration())
                                .totalSlots(doctorShedule.getTotalSlots())
                                .status(doctorShedule.getStatus())
                                .doctor(doctorShedule.getDoctor())
                                .speciality(doctorShedule.getSpeciality())
                                .consultingRoom(doctorShedule.getConsultingRoom())
                                .reservedSlots(reservedSlots) // Asignar los slots reservados
                                .build();
        }

        public List<DoctorSheduleResponse> toResponseList(List<DoctorShedule> doctorShedules) {
                return doctorShedules.stream()
                                .map(this::toResponse)
                                .collect(Collectors.toList());
        }
}
