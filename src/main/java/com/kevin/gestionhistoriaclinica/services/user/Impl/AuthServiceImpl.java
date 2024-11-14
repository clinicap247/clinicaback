package com.kevin.gestionhistoriaclinica.services.user.Impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.kevin.gestionhistoriaclinica.Jwt.JwtService;
import com.kevin.gestionhistoriaclinica.mapper.user.AuthMapper;
import com.kevin.gestionhistoriaclinica.models.dto.user.AuthResponse;
import com.kevin.gestionhistoriaclinica.models.dto.user.LoginDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;
import com.kevin.gestionhistoriaclinica.services.user.IAuthService;
import com.kevin.gestionhistoriaclinica.services.user.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final IUserService userService;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final AuthMapper authMapper;

    @Override
    public AuthResponse login(LoginDto authDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDto.getEmail(),
                        authDto.getPassword()));
        User user = userService.findByEmail(authDto.getEmail());
        String token = jwtService.getToken(user);
        return authMapper.toResponseDto(user, token);
    }

}
