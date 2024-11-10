package com.kevin.gestionhistoriaclinica.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;

public interface PatientJpaDao extends JpaRepository<Patient, Long> {
}
