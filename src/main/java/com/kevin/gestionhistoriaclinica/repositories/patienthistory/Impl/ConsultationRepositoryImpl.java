package com.kevin.gestionhistoriaclinica.repositories.patienthistory.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.patienthistory.ConsultationJpaDao;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.repositories.patienthistory.IConsultationRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ConsultationRepositoryImpl implements IConsultationRepository {

    private final ConsultationJpaDao consultationDao;

    @Override
    public List<Consultation> findAll() {
        List<Consultation> consultations = consultationDao.findAll();
        return consultations;
    }

    @Override
    public Optional<Consultation> findById(Long id) {
        Optional<Consultation> consultation = consultationDao.findById(id);
        return consultation;
    }

    @Override
    public Consultation save(Consultation consultion) {
        return consultationDao.save(consultion);
    }

    @Override
    public void delete(Long id) {
        consultationDao.deleteById(id);
    }

}
