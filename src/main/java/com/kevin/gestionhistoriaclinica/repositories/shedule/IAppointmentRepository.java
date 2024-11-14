package com.kevin.gestionhistoriaclinica.repositories.shedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;

public interface IAppointmentRepository {
    List<Appointment> findAll(AppointmentParams params);

    Optional<Appointment> findById(Long id);

    Optional<Appointment> find(DoctorShedule doctorShedule, Integer slotNumber,
            LocalDate appointmentDate);

    Appointment save(Appointment doctorShedule);

    void delete(Long id);

}
