package com.kevin.gestionhistoriaclinica.models.entities.patienthistory;

import java.time.LocalDate;

import com.kevin.gestionhistoriaclinica.models.enums.ConsultationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "consultation_date")
    private LocalDate consultationDate;
    @Builder.Default
    @Column(nullable = true)
    private String diagnosic = null;
    @Builder.Default
    private ConsultationStatus status = ConsultationStatus.PENDING;

    @OneToOne
    private MedicalHistory medicalHistory;
}
