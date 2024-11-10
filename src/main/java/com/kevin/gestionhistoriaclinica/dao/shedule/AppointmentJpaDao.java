package com.kevin.gestionhistoriaclinica.dao.shedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;

public interface AppointmentJpaDao extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {

}
