package com.kevin.gestionhistoriaclinica.services.user.Impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.user.UserMapper;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;
import com.kevin.gestionhistoriaclinica.repositories.user.IUserRepository;
import com.kevin.gestionhistoriaclinica.services.user.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    @Transactional
    public User save(UserDto dto) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User save(UserDto dto, Role role) {
        User user = userMapper.toEntity(dto);
        user.setRoles(Collections.singletonList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, UserDto dto) {
        User user = findByIdWithException(id);
        userMapper.updateEntityFromDto(dto, user);

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        findByIdWithException(id);
        userRepository.delete(id);
        return true;
    }

    @Transactional(readOnly = true)
    private User findByIdWithException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", email)));
    }
}
