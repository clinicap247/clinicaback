package com.kevin.gestionhistoriaclinica.services.user;

import com.kevin.gestionhistoriaclinica.models.entities.user.Role;

public interface IRoleService {
    Role findById(Long id);

    Role getRoleAdmin();

    Role getRoleDoctor();

    Role getRolePatient();
}
