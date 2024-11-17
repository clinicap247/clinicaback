package com.kevin.gestionhistoriaclinica.controllers.patienthistory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.services.patienthistory.IConsultaionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ConsultationGraphqlController {
    private final IConsultaionService consultaionService;

    @QueryMapping
    public List<Consultation> consultations() {
        return consultaionService.findAll();
    }

    @QueryMapping
    public Consultation consultation(@Argument Long id) {
        return consultaionService.findById(id);
    }

    @MutationMapping
    public Consultation createConsultation(@Argument ConsultationDto input) {
        return consultaionService.save(input);
    }
}
