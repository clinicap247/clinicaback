package com.kevin.gestionhistoriaclinica.models.dto.shedule;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentParams {
    private LocalDate appointmentDate;
    private Integer slotNumber;
    private Boolean status;

    // Relaciones
    private Long patientId;
    private Long doctorSheduleId;
    private Long doctorId;
    private Long specialityId;
}
