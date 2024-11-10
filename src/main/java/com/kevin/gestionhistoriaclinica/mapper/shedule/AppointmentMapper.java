package com.kevin.gestionhistoriaclinica.mapper.shedule;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.util.date.DateParser;

@Component
public class AppointmentMapper {
    public Appointment toEntity(AppointmentDto dto, Patient patient, DoctorShedule doctorShedule) {
        return Appointment.builder()
                .appointmentDate(DateParser.parseDate(LocalDate.now()))
                .slotNumber(dto.getSlotNumber())
                .patient(patient)
                .doctorShedule(doctorShedule)

                .build();
    }

    public Appointment updateEntityFromDto(AppointmentDto dto, Appointment appointment) {
        appointment.setId(dto.getId());
        // Solo se modifica el estado
        appointment.setStatus(dto.getStatus());

        return appointment;
    }
}
