package com.kevin.gestionhistoriaclinica.models.dto.patienthistory;

import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.DiagnosticFile;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.LaboratoryTest;
import com.kevin.gestionhistoriaclinica.models.entities.patienthistory.Medication;
import com.kevin.gestionhistoriaclinica.models.enums.ConsultationStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ConsultationDto {
    private Long id;
    private String date;
    private String diagnosis;
    private ConsultationStatus status;

    // Data of Medical History
    private Long appointmentId;

    // Data de Laboratory Test
    private LaboratoryTest laboratoryTest;
    // Diagnostic
    private DiagnosticFile diagnosticFile;
    // Medication
    private Medication medication;
}
