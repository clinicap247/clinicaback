package com.kevin.gestionhistoriaclinica.dao.patienthistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.DiagnosticFile;

public interface DiagnosticFileDao extends JpaRepository<DiagnosticFile, Long> {
}
