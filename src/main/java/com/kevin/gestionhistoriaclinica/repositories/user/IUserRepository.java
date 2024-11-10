package com.kevin.gestionhistoriaclinica.repositories.user;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.user.User;

public interface IUserRepository {
    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    User save(User user);

    void delete(Long id);
}
