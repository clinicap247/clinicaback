package com.kevin.gestionhistoriaclinica.repositories.patienthistory;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Consultation;

public interface IConsultationRepository {
    List<Consultation> findAll();

    Optional<Consultation> findById(Long id);

    Consultation save(Consultation consultion);

    void delete(Long id);
}
