package com.kevin.gestionhistoriaclinica.services.shedule;

import java.time.LocalDate;
import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;

public interface IAppointmentService {
    List<Appointment> findAll(AppointmentParams params);

    Appointment findById(Long id);

    // Appointment find(Long doctorSheduleId, Integer slotNumber,
    // LocalDate appointmentDate);

    Appointment save(AppointmentDto dto);

    Appointment update(Long id, AppointmentDto dto);

    Boolean delete(Long id);
}
