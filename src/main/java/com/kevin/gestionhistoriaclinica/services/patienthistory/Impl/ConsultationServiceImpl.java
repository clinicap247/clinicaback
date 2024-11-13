package com.kevin.gestionhistoriaclinica.services.patienthistory.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;
import com.kevin.gestionhistoriaclinica.services.patienthistory.IConsultaionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements IConsultaionService {

    @Override
    public List<Consultation> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Consultation findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Consultation save(ConsultationDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Consultation update(Long id, ConsultationDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
