package com.kevin.gestionhistoriaclinica.controllers.shedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.services.shedule.ISpecialityService;

@Controller
public class SpecialityGraphqlController {
    @Autowired
    private ISpecialityService specialityService;

    @QueryMapping
    public List<Speciality> specialities() {
        return specialityService.findAll();
    }

    @QueryMapping
    public Speciality speciality(@Argument Long id) {
        return specialityService.findById(id);
    }

    @MutationMapping
    public Speciality createSpeciality(@Argument SpecialityStoreDto input) {
        return specialityService.save(input);
    }

    @MutationMapping
    public Speciality updateSpeciality(@Argument Long id, @Argument SpecialityUpdateDto input) {
        return specialityService.update(id, input);
    }

    @MutationMapping
    public Boolean deleteSpeciality(@Argument Long id) {
        return specialityService.delete(id);
    }
}
