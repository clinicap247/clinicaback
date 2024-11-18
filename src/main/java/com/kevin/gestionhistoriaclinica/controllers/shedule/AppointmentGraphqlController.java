package com.kevin.gestionhistoriaclinica.controllers.shedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.services.shedule.IAppointmentService;

@Controller
public class AppointmentGraphqlController {

    @Autowired
    private IAppointmentService appointmentService;

    @QueryMapping
    public List<Appointment> appointments(@Argument AppointmentParams params) {
        System.out.println("Parametros: " + params);
        if (params == null) {
            params = new AppointmentParams();
        }
        return appointmentService.findAll(params);
    }

    @QueryMapping
    public Appointment appointment(@Argument Long id) {
        return appointmentService.findById(id);
    }

    @MutationMapping
    public Appointment createAppointment(@Argument AppointmentDto input) {
        return appointmentService.save(input);
    }

    @MutationMapping
    public Appointment updateAppointment(@Argument Long id, @Argument AppointmentDto input) {
        return appointmentService.update(id, input);
    }

    @MutationMapping
    public Boolean deleteAppointment(@Argument Long id) {
        return appointmentService.delete(id);
    }
}
