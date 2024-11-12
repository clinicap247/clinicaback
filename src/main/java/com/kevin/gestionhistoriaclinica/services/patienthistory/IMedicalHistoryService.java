package com.kevin.gestionhistoriaclinica.services.patienthistory;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.MedicalHistoryDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;

public interface IMedicalHistoryService {
    public List<MedicalHistory> findAll();

    public MedicalHistory findById(Long id);

    public MedicalHistory save(MedicalHistoryDto medicalHistory);

    // public MedicalHistory update(Long id, MedicalHistory medicalHistory);

    // public Boolean delete(Long id);
}
