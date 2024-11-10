package com.kevin.gestionhistoriaclinica.repositories.user;

import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.user.Role;

public interface IRoleRepository {
    Optional<Role> findById(Long id);

    Optional<Role> findByName(String name);

    Role save(Role role);

    Role getRoleAdmin();

    Role getRoleDoctor();

    Role getRolePatient();
}
