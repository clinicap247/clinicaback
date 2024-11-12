package com.kevin.gestionhistoriaclinica.repositories.patienthistory;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;

public interface IMedicalHistoryRepository {
    List<MedicalHistory> findAll();

    Optional<MedicalHistory> findById(Long id);

    MedicalHistory save(MedicalHistory medicalHistory);

    void delete(Long id);
}
