package com.kevin.gestionhistoriaclinica.dao.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.user.User;

public interface UserJpaDao extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
