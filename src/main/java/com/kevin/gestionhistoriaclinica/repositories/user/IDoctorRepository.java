package com.kevin.gestionhistoriaclinica.repositories.user;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;

public interface IDoctorRepository {
    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);

    Doctor save(Doctor doctor);

    void delete(Long id);
}
