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
public class MedicalHistoryDto {
    private Long id;
    private Long patientId;
}
