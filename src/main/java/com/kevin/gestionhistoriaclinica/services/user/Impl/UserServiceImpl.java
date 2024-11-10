package com.kevin.gestionhistoriaclinica.services.user.Impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.user.UserMapper;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;
import com.kevin.gestionhistoriaclinica.repositories.user.IUserRepository;
import com.kevin.gestionhistoriaclinica.services.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    @Transactional
    public User save(UserDto dto) {
        User user = userMapper.toEntity(dto);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User save(UserDto dto, Role role) {
        User user = userMapper.toEntity(dto);
        user.setRoles(Collections.singletonList(role));

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
}
