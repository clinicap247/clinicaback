package com.kevin.gestionhistoriaclinica.services.shedule;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;

public interface IAppointmentService {
    public List<Appointment> findAll(AppointmentParams params);

    public Appointment findById(Long id);

    public Appointment save(AppointmentDto dto);

    public Appointment update(Long id, AppointmentDto dto);

    public Boolean delete(Long id);
}
