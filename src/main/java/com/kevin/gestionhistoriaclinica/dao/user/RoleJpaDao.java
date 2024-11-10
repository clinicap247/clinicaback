package com.kevin.gestionhistoriaclinica.dao.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.user.Role;

public interface RoleJpaDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
