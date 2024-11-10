package com.kevin.gestionhistoriaclinica.repositories.user.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.user.RoleJpaDao;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.repositories.user.IRoleRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RoleJpaRepository implements IRoleRepository {

    // public final Long ADMIN_ID = 1L;
    // public final Long DOCTOR_ID = 2L;
    // public final Long PATIENT_ID = 3L;

    @Autowired
    private RoleJpaDao roleDao;

    @Override
    public Optional<Role> findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleDao.findByName(name);
    }

    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role getRoleAdmin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoleAdmin'");
    }

    @Override
    public Role getRoleDoctor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoleDoctor'");
    }

    @Override
    public Role getRolePatient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRolePatient'");
    }

}
