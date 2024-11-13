package com.kevin.gestionhistoriaclinica.services.patienthistory;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.patienthistory.ConsultationDto;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;

public interface IConsultaionService {
    List<Consultation> findAll();

    Consultation findById(Long id);

    Consultation save(ConsultationDto dto);

    Consultation update(Long id, ConsultationDto dto);

    Boolean delete(Long id);
}
