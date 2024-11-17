package com.kevin.gestionhistoriaclinica.controllers.user;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.user.PatientDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.services.user.IPatientService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PatientGraphqlController {

    private final IPatientService patientService;

    @QueryMapping
    public List<Patient> patients() {
        return patientService.findAll();
    }

    @QueryMapping
    public Patient patient(@Argument Long id) {
        return patientService.findById(id);
    }

    @MutationMapping
    public Patient createPatient(@Argument PatientDto input) {
        return patientService.save(input);
    }

    @MutationMapping
    public Patient updatePatient(@Argument Long id, @Argument PatientDto input) {
        return patientService.update(id, input);
    }
}
