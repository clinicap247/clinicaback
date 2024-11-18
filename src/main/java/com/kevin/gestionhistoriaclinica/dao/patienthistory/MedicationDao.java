package com.kevin.gestionhistoriaclinica.dao.patienthistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Medication;

public interface MedicationDao extends JpaRepository<Medication, Long> {
}
