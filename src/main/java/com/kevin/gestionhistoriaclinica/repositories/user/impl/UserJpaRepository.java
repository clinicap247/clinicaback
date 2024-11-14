package com.kevin.gestionhistoriaclinica.repositories.user.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.user.UserJpaDao;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;
import com.kevin.gestionhistoriaclinica.repositories.user.IUserRepository;

@Repository("userRepository")
public class UserJpaRepository implements IUserRepository {

    @Autowired
    private UserJpaDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByUsername(email);
    }

    @Override
    public User save(User user) {
        User userSaved = userDao.save(user);
        return userSaved;
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
