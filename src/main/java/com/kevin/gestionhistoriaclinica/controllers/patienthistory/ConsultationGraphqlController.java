package com.kevin.gestionhistoriaclinica.controllers.patienthistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.services.patienthistory.IConsultaionService;

@Controller
public class ConsultationGraphqlController {
    @Autowired
    private IConsultaionService consultaionService;

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

    @MutationMapping
    public Consultation updateConsultation(@Argument Long id, @Argument ConsultationDto input) {
        return consultaionService.update(id, input);
    }
}
