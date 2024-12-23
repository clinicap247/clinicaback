package com.kevin.gestionhistoriaclinica.dao.patienthistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;

public interface ConsultationJpaDao extends JpaRepository<Consultation, Long> {
}
