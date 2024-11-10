package com.kevin.gestionhistoriaclinica.services.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.repositories.user.impl.RoleJpaRepository;
import com.kevin.gestionhistoriaclinica.services.user.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleJpaRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    public Role getRoleAdmin() {
        return findByIdWithException(1L);
    }

    @Override
    public Role getRoleDoctor() {
        System.out.println("Obteniendo rol");
        return findByIdWithException(2L);
    }

    @Override
    public Role getRolePatient() {
        return findByIdWithException(3L);
    }

    @Transactional(readOnly = true)
    private Role findByIdWithException(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", id));
    }

}
