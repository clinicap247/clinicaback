package com.kevin.gestionhistoriaclinica.mapper.user;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.user.AuthResponse;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;

@Component
public class AuthMapper {
    public AuthResponse toResponseDto(User user, String token) {
        return AuthResponse.builder()
                .token(token)
                .user(user)
                .build();
    }
}
