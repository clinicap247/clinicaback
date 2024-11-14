package com.kevin.gestionhistoriaclinica.dao.shedule;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;

public interface AppointmentJpaDao extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {
    Appointment findByDoctorSheduleAndSlotNumberAndAppointmentDate(DoctorShedule doctorShedule, Integer slotNumber,
            LocalDate appointmentDate);
}
