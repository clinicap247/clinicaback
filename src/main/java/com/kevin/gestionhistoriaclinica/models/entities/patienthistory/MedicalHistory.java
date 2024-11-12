package com.kevin.gestionhistoriaclinica.models.entities.patienthistory;

import java.time.LocalDate;

import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "medical_histories")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public MedicalHistory(LocalDate creationDate, Patient patient) {
        this.creationDate = creationDate;
        this.patient = patient;
    }
}
