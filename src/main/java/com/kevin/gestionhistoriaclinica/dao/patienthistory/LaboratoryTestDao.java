package com.kevin.gestionhistoriaclinica.dao.patienthistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.LaboratoryTest;

public interface LaboratoryTestDao extends JpaRepository<LaboratoryTest, Long> {
}
