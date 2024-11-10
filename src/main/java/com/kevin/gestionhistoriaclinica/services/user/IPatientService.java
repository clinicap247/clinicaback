package com.kevin.gestionhistoriaclinica.services.user;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.user.PatientDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;

public interface IPatientService {
    List<Patient> findAll();

    Patient findById(Long id);

    Patient save(PatientDto dto);

    Patient update(Long id, PatientDto dto);

    // Boolean delete(Long id);
}
