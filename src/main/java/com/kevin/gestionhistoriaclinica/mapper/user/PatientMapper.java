package com.kevin.gestionhistoriaclinica.mapper.user;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.user.PatientDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;
import com.kevin.gestionhistoriaclinica.util.date.DateParser;

@Component
public class PatientMapper {

    public Patient toEntity(PatientDto dto, User user) {
        return Patient.builder()
                .ic(dto.getIc())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .birthdate(DateParser.parseDate(dto.getBirthdate()))
                .user(user) // Asociar el usuario al paciente
                .build();
    }

    public Patient updateEntityFromDto(Patient patient, PatientDto dto) {
        patient.setId(dto.getId());
        patient.setIc(dto.getIc());
        patient.setAddress(dto.getAddress());
        patient.setPhone(dto.getPhone());
        patient.setBirthdate(DateParser.parseDate(dto.getBirthdate()));

        return patient;
    }

}
