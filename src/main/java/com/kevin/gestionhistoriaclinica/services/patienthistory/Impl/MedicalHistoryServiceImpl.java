package com.kevin.gestionhistoriaclinica.services.patienthistory.Impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.MedicalHistoryDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.repositories.patienthistory.IMedicalHistoryRepository;

import lombok.RequiredArgsConstructor;

import com.kevin.gestionhistoriaclinica.services.patienthistory.IMedicalHistoryService;
import com.kevin.gestionhistoriaclinica.services.user.IPatientService;
import com.kevin.gestionhistoriaclinica.util.date.DateParser;

@Service
@RequiredArgsConstructor
public class MedicalHistoryServiceImpl implements IMedicalHistoryService {

    private final IMedicalHistoryRepository medicalHistoryRepository;
    // Services
    private final IPatientService patientService;

    @Override
    public List<MedicalHistory> findAll() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public MedicalHistory findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    public MedicalHistory save(MedicalHistoryDto medicalHistory) {
        Patient patient = patientService.findById(medicalHistory.getPatientId());
        MedicalHistory newMedicalHistory = new MedicalHistory(
                DateParser.parseDate(LocalDate.now()),
                patient);

        return medicalHistoryRepository.save(newMedicalHistory);
    }

    // @Override
    // public MedicalHistory update(Long id, MedicalHistory medicalHistory) {
    // MedicalHistory medicalHistoryToUpdate = findByIdWithException(id);
    // medicalHistoryToUpdate.setPatient(medicalHistory.getPatient());
    // return medicalHistoryRepository.save(medicalHistoryToUpdate);
    // }

    // @Override
    // public Boolean delete(Long id) {
    // findByIdWithException(id);
    // medicalHistoryRepository.delete(id);
    // return true;
    // }

    private MedicalHistory findByIdWithException(Long id) {
        return medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalHistory", "id", id));
    }
}
