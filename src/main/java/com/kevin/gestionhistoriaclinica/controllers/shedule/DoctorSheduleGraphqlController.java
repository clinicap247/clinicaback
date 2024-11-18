package com.kevin.gestionhistoriaclinica.controllers.shedule;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleParams;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleResponse;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoreDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.services.shedule.IDoctorSheduleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DoctorSheduleGraphqlController {
    private final IDoctorSheduleService doctorSheduleService;

    @QueryMapping
    public List<DoctorSheduleResponse> doctorShedules(@Argument DoctorSheduleParams params) {
        if (params == null) {
            params = new DoctorSheduleParams();
        }
        return doctorSheduleService.findAll(params);
    }

    @QueryMapping
    public DoctorShedule doctorShedule(@Argument Long id) {
        return doctorSheduleService.findById(id);
    }

    @MutationMapping
    public DoctorShedule createDoctorShedule(@Argument DoctorSheduleStoreDto input) {
        return doctorSheduleService.save(input);
    }

    @MutationMapping
    public DoctorShedule updateDoctorShedule(@Argument Long id, @Argument DoctorSheduleStoreDto input) {
        return doctorSheduleService.update(id, input);
    }

    @MutationMapping
    public Boolean deleteDoctorShedule(@Argument Long id) {
        return doctorSheduleService.delete(id);
    }
}
