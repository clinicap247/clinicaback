package com.kevin.gestionhistoriaclinica.controllers.user;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;
import com.kevin.gestionhistoriaclinica.services.user.IDoctorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DoctorGraphqlController {
    private final IDoctorService doctorService;

    @QueryMapping
    public List<Doctor> doctors() {
        return doctorService.findAll();
    }

    @QueryMapping
    public Doctor doctor(@Argument Long id) {
        return doctorService.findById(id);
    }

    @MutationMapping
    public Doctor createDoctor(@Argument DoctorStoreDto input) {
        System.out.println("Input: " + input);
        return doctorService.save(input);
    }

    @MutationMapping
    public Doctor updateDoctor(@Argument Long id, @Argument DoctorUpdateDto input) {
        return doctorService.update(id, input);
    }

    @MutationMapping
    public Boolean deleteDoctor(@Argument Long id) {
        return doctorService.delete(id);
    }
}
