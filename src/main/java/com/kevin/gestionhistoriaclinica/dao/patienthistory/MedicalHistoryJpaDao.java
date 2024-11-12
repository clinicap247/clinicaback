package com.kevin.gestionhistoriaclinica.dao.patienthistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;

public interface MedicalHistoryJpaDao extends JpaRepository<MedicalHistory, Long> {

}
