package com.kevin.gestionhistoriaclinica.controllers.patienthistory;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.MedicalHistoryDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;
import com.kevin.gestionhistoriaclinica.services.patienthistory.IMedicalHistoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MedicalHistoryGraphqlController {

    private final IMedicalHistoryService medicalHistoryService;

    @QueryMapping
    public List<MedicalHistory> medicalHistories() {
        return medicalHistoryService.findAll();
    }

    @QueryMapping
    public MedicalHistory medicalHistory(@Argument Long id) {
        return medicalHistoryService.findById(id);
    }

    @MutationMapping
    public MedicalHistory createMedicalHistory(@Argument MedicalHistoryDto input) {
        return medicalHistoryService.save(input);
    }
}
