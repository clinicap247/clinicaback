package com.kevin.gestionhistoriaclinica.mapper.patienthistory;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.util.date.DateParser;

@Component
public class ConsultationMapper {
    public Consultation toEntity(ConsultationDto dto, Appointment appointment) {
        return Consultation.builder()
                .id(dto.getId())
                .consultationDate(DateParser.parseDate(LocalDate.now()))
                .diagnosic(dto.getDiagnosis())
                .appointment(appointment)
                .build();
    }

    public Consultation updateEntityFromDto(ConsultationDto dto, Consultation consultation) {
        Optional.ofNullable(dto.getId()).ifPresent(consultation::setId);
        Optional.ofNullable(dto.getDiagnosis()).ifPresent(consultation::setDiagnosic);
        Optional.ofNullable(dto.getStatus()).ifPresent(consultation::setStatus);
        return consultation;
    }
}
