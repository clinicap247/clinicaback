package com.kevin.gestionhistoriaclinica.models.entities.user;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Referencia de relacion muchos a muchos, puede causar problemas de bucle
    // infinito
    // @Builder.Default
    // @JsonIgnoreProperties({ "roles", "handler", "hibernateLazyInitializer" })
    // @ManyToMany(mappedBy = "roles")
    // private List<User> users = new ArrayList<>();
}
