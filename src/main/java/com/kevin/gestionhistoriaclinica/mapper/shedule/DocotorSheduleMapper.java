package com.kevin.gestionhistoriaclinica.mapper.shedule;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleUpdateDto;
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

    public DoctorShedule updateEntityFromDto(DoctorSheduleUpdateDto dto, DoctorShedule doctorShedule, int totalSlots,
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
}
