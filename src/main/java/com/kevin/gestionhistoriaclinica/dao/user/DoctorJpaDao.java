package com.kevin.gestionhistoriaclinica.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;

public interface DoctorJpaDao extends JpaRepository<Doctor, Long> {
    @Override
    @EntityGraph(attributePaths = { "user.roles" })
    @NonNull
    List<Doctor> findAll();
}
