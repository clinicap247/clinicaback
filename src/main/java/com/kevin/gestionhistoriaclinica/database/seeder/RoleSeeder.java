package com.kevin.gestionhistoriaclinica.database.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.repositories.user.IRoleRepository;

@Component
public class RoleSeeder implements Runnable {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void run() {
        List<String> roles = List.of("ROLE_ADMIN", "ROLE_DOCTOR", "ROLE_PATIENT");
        for (String roleName : roles) {
            roleRepository.findByName(roleName).orElseGet(() -> {
                Role role = Role.builder().name(roleName).build();
                return roleRepository.save(role);
            });
        }
    }

}
