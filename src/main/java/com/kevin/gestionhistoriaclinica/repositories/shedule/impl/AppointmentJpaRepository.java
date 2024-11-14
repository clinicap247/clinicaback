package com.kevin.gestionhistoriaclinica.repositories.shedule.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.shedule.AppointmentJpaDao;
import com.kevin.gestionhistoriaclinica.dao.shedule.specifications.AppointmentSpecifications;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.repositories.shedule.IAppointmentRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AppointmentJpaRepository implements IAppointmentRepository {

    final private AppointmentJpaDao appointmentDao;

    @Override
    public List<Appointment> findAll(AppointmentParams params) {
        return appointmentDao.findAll(AppointmentSpecifications.withParams(params));
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentDao.findById(id);
    }

    @Override
    public Optional<Appointment> find(DoctorShedule doctorShedule, Integer slotNumber, LocalDate appointmentDate) {
        return Optional.ofNullable(appointmentDao
                .findByDoctorSheduleAndSlotNumberAndAppointmentDate(doctorShedule, slotNumber, appointmentDate));
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentDao.save(appointment);
    }

    @Override
    public void delete(Long id) {
        appointmentDao.deleteById(id);
    }

}
