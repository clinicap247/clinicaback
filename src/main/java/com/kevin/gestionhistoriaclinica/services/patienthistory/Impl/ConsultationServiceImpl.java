package com.kevin.gestionhistoriaclinica.services.patienthistory.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.patienthistory.ConsultationMapper;
import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.MedicalHistory;
import com.kevin.gestionhistoriaclinica.models.enums.ConsultationStatus;
import com.kevin.gestionhistoriaclinica.repositories.patienthistory.Impl.ConsultationRepositoryImpl;
import com.kevin.gestionhistoriaclinica.services.patienthistory.IConsultaionService;
import com.kevin.gestionhistoriaclinica.services.patienthistory.IMedicalHistoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements IConsultaionService {

    private final ConsultationRepositoryImpl consultationRepository;
    // Services
    private final IMedicalHistoryService medicalHistoryService;
    // Mapper
    private final ConsultationMapper consultationMapper;

    @Override
    public List<Consultation> findAll() {
        List<Consultation> consultations = consultationRepository.findAll();
        return consultations;
    }

    @Override
    public Consultation findById(Long id) {
        Consultation consultation = findByIdWithException(id);
        return consultation;
    }

    @Override
    public Consultation save(ConsultationDto dto) {
        MedicalHistory medicalHistory = medicalHistoryService.save(dto.getPatientId());
        Consultation consultation = consultationMapper.toEntity(dto, medicalHistory);
        // Por defecto pendiente
        consultation.setStatus(ConsultationStatus.PENDING);
        consultation = consultationRepository.save(consultation);
        return consultation;
    }

    @Override
    public Consultation update(Long id, ConsultationDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Consultation findByIdWithException(Long id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation", "id", id));
    }

}
