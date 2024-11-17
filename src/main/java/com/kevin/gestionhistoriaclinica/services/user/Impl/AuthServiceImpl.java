package com.kevin.gestionhistoriaclinica.services.user.Impl;

import org.springframework.stereotype.Service;

import com.kevin.gestionhistoriaclinica.models.dto.user.AuthResponse;
import com.kevin.gestionhistoriaclinica.models.dto.user.LoginDto;
import com.kevin.gestionhistoriaclinica.services.user.IAuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    @Override
    public AuthResponse login(LoginDto authDto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // private final IUserService userService;
    // private final JwtService jwtService;

    // private final AuthenticationManager authenticationManager;

    // private final AuthMapper authMapper;

    // @Override
    // public AuthResponse login(LoginDto authDto) {
    // authenticationManager.authenticate(
    // new UsernamePasswordAuthenticationToken(authDto.getEmail(),
    // authDto.getPassword()));
    // User user = userService.findByEmail(authDto.getEmail());
    // String token = jwtService.getToken(user);
    // return authMapper.toResponseDto(user, token);
    // }

}
