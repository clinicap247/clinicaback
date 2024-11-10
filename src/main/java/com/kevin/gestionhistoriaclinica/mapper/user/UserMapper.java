package com.kevin.gestionhistoriaclinica.mapper.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.user.UserResponseDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;

@Component
public class UserMapper {

    public User toEntity(UserDto dto) {
        return User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .enabled(dto.getEnabled())
                .userType(dto.getUserType())
                .build();
    }

    public User updateEntityFromDto(UserDto dto, User user) {
        user.setId(dto.getId());
        user.setFullName(dto.getFullName());
        user.setEnabled(dto.getEnabled());
        user.setEmail(dto.getEmail());

        return user;
    }

    public UserResponseDto toResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .enabled(user.getEnabled())
                .userType(user.getUserType())
                .build();
    }

    public List<UserResponseDto> toResponseDtoList(List<User> users) {
        return users.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}
