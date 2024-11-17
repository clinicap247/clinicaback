package com.kevin.gestionhistoriaclinica.models.dto.patienthistory;

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

    // Relations
    private Long medicalHistoryId;

    // Data of Medical History
    private Long patientId;
}
