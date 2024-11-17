package com.kevin.gestionhistoriaclinica.services.patienthistory;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.MedicalHistoryDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;

public interface IMedicalHistoryService {
    List<MedicalHistory> findAll();

    MedicalHistory findById(Long id);

    MedicalHistory save(MedicalHistoryDto medicalHistory);

    MedicalHistory save(Long patientId);
}
