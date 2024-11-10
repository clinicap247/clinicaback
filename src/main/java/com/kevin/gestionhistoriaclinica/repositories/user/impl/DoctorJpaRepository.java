package com.kevin.gestionhistoriaclinica.repositories.user.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.user.DoctorJpaDao;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;
import com.kevin.gestionhistoriaclinica.repositories.user.IDoctorRepository;

@Repository
public class DoctorJpaRepository implements IDoctorRepository {

    @Autowired
    private DoctorJpaDao doctorDao;

    @Override
    public Doctor save(Doctor doctor) {
        return doctorDao.save(doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        doctorDao.findById(id);
    }
}
