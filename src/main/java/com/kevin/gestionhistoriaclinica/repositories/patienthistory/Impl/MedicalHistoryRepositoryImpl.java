package com.kevin.gestionhistoriaclinica.repositories.patienthistory.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;
import com.kevin.gestionhistoriaclinica.repositories.patienthistory.IMedicalHistoryRepository;

import lombok.RequiredArgsConstructor;

import com.kevin.gestionhistoriaclinica.dao.patienthistory.MedicalHistoryJpaDao;

@Repository
@RequiredArgsConstructor
public class MedicalHistoryRepositoryImpl implements IMedicalHistoryRepository {

    private final MedicalHistoryJpaDao medicalHistoryDao;

    @Override
    public List<MedicalHistory> findAll() {
        List<MedicalHistory> medicalHistories = medicalHistoryDao.findAll();
        return medicalHistories;
    }

    @Override
    public Optional<MedicalHistory> findById(Long id) {
        Optional<MedicalHistory> medicalHistory = medicalHistoryDao.findById(id);
        return medicalHistory;
    }

    @Override
    public MedicalHistory save(MedicalHistory medicalHistory) {
        MedicalHistory medicalHistorySaved = medicalHistoryDao.save(medicalHistory);
        return medicalHistorySaved;
    }

    @Override
    public void delete(Long id) {
        medicalHistoryDao.deleteById(id);
    }
}
