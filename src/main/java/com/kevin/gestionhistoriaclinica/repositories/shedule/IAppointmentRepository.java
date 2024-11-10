package com.kevin.gestionhistoriaclinica.repositories.shedule;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;

//Push
public interface IAppointmentRepository {
    List<Appointment> findAll(AppointmentParams params);

    Optional<Appointment> findById(Long id);

    Appointment save(Appointment doctorShedule);

    void delete(Long id);
}
