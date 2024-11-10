package com.kevin.gestionhistoriaclinica.repositories.shedule;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;

public interface ISpecialityRepository {
    List<Speciality> findAll();

    Optional<Speciality> findById(Long id);

    Optional<Speciality> findByName(String name);

    Speciality save(Speciality speciality);

    void delete(Long id);
}
