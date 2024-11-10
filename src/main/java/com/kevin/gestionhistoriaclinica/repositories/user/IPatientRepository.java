package com.kevin.gestionhistoriaclinica.repositories.user;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;

public interface IPatientRepository {
    List<Patient> findAll();

    Optional<Patient> findById(Long id);

    Patient save(Patient patient);
}
