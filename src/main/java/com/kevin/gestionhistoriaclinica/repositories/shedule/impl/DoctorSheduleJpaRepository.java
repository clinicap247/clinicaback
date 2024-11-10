package com.kevin.gestionhistoriaclinica.repositories.shedule.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.shedule.DoctorSheduleJpaDao;
import com.kevin.gestionhistoriaclinica.dao.shedule.specifications.DoctorSheduleSpecifications;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.repositories.shedule.IDoctorSheduleRepository;

@Repository
public class DoctorSheduleJpaRepository implements IDoctorSheduleRepository {

    @Autowired
    private DoctorSheduleJpaDao doctorSheduleDao;

    @Override
    public List<DoctorShedule> findAll() {
        return doctorSheduleDao.findAll();
    }

    @Override
    public Optional<DoctorShedule> findById(Long id) {
        return doctorSheduleDao.findById(id);
    }

    @Override
    public DoctorShedule save(DoctorShedule doctorShedule) {
        return doctorSheduleDao.save(doctorShedule);
    }

    @Override
    public void delete(Long id) {
        doctorSheduleDao.deleteById(id);
    }

    @Override
    public List<DoctorShedule> findByParams(DoctorSheduleParams params) {
        return doctorSheduleDao.findAll(DoctorSheduleSpecifications.withParams(params));
    }

}
