package com.kevin.gestionhistoriaclinica.services.patienthistory.Impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kevin.gestionhistoriaclinica.dao.patienthistory.DiagnosticFileDao;
import com.kevin.gestionhistoriaclinica.dao.patienthistory.LaboratoryTestDao;
import com.kevin.gestionhistoriaclinica.dao.patienthistory.MedicationDao;
import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.patienthistory.ConsultationMapper;
import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.DiagnosticFile;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.LaboratoryTest;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Medication;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.models.enums.ConsultationStatus;
import com.kevin.gestionhistoriaclinica.repositories.patienthistory.Impl.ConsultationRepositoryImpl;
import com.kevin.gestionhistoriaclinica.services.patienthistory.IConsultaionService;
import com.kevin.gestionhistoriaclinica.services.shedule.IAppointmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements IConsultaionService {

    private final ConsultationRepositoryImpl consultationRepository;
    private final LaboratoryTestDao laboratoryTestDao;
    private final DiagnosticFileDao diagnosticFileDao;
    private final MedicationDao medicationDao;

    // Service
    private final IAppointmentService appointmentService;
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
        Appointment appointment = appointmentService.findById(dto.getAppointmentId());
        Consultation consultation = consultationMapper.toEntity(dto, appointment);
        consultation.setStatus(ConsultationStatus.PENDING);
        consultation = consultationRepository.save(consultation);
        return consultation;
    }

    @Override
    public Consultation update(Long id, ConsultationDto dto) {
        Consultation consultation = findByIdWithException(id);
        dto.setId(id);

        consultation = consultationMapper.updateEntityFromDto(dto, consultation);
        consultation = consultationRepository.save(consultation);

        if (dto.getLaboratoryTest() != null) {
            LaboratoryTest laboratoryTest = dto.getLaboratoryTest();
            laboratoryTest.setConsultation(consultation);
            laboratoryTestDao.save(laboratoryTest);
        }

        if (dto.getDiagnosticFile() != null) {
            DiagnosticFile diagnosticFile = dto.getDiagnosticFile();
            diagnosticFile.setConsultation(consultation);
            diagnosticFileDao.save(diagnosticFile);
        }

        if (dto.getMedication() != null) {
            Medication medication = dto.getMedication();
            medication.setConsultation(consultation);
            medicationDao.save(medication);
        }

        return consultation;
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
