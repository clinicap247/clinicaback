package com.kevin.gestionhistoriaclinica.mapper.patienthistory;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;
import com.kevin.gestionhistoriaclinica.util.date.DateParser;

@Component
public class ConsultationMapper {
    public Consultation toEntity(ConsultationDto dto, MedicalHistory medicalHistory) {
        return Consultation.builder()
                .id(dto.getId())
                .consultationDate(DateParser.parseDate(LocalDate.now()))
                .diagnosic(dto.getDiagnosis())
                .medicalHistory(medicalHistory)
                .build();
    }
}
