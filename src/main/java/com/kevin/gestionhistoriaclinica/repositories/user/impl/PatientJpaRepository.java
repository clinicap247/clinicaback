package com.kevin.gestionhistoriaclinica.repositories.user.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.user.PatientJpaDao;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.repositories.user.IPatientRepository;

@Repository
public class PatientJpaRepository implements IPatientRepository {

    @Autowired
    private PatientJpaDao patientDao;

    @Override
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientDao.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientDao.save(patient);
    }
}
