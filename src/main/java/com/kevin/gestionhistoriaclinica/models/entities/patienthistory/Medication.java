package com.kevin.gestionhistoriaclinica.models.entities.patienthistory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "dose", nullable = true)
    private String dose;
    @Column(name = "frequency", nullable = true)
    private String frequency;
    @Column(name = "duration", nullable = true)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}
