package com.kevin.gestionhistoriaclinica.repositories.shedule.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.shedule.SpecialityJpaDao;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.repositories.shedule.ISpecialityRepository;

@Repository
public class SpecialityJpaRepository implements ISpecialityRepository {

    @Autowired
    private SpecialityJpaDao specialityDao;

    @Override
    public List<Speciality> findAll() {
        return specialityDao.findAll();
    }

    @Override
    public Optional<Speciality> findById(Long id) {
        return specialityDao.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityDao.save(speciality);
    }

    @Override
    public void delete(Long id) {
        specialityDao.deleteById(id);
    }

    @Override
    public Optional<Speciality> findByName(String name) {
        return specialityDao.findByName(name);
    }
}
