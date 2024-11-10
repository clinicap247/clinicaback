package com.kevin.gestionhistoriaclinica.models.dto.shedule;

import java.time.LocalDate;

import com.kevin.gestionhistoriaclinica.models.enums.AppointmentStatus;

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
public class AppointmentDto {
    @Builder.Default
    private Long id = null;
    private LocalDate appointmentDate;
    private Integer slotNumber;
    private AppointmentStatus status;

    // Relations
    private Long patientId;
    private Long doctorSheduleId;
}
