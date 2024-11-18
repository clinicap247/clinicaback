package com.kevin.gestionhistoriaclinica.controllers.auth;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.gestionhistoriaclinica.models.dto.user.AuthResponse;
import com.kevin.gestionhistoriaclinica.models.dto.user.LoginDto;
import com.kevin.gestionhistoriaclinica.services.user.IAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        AuthResponse authResponse = authService.login(loginDto);
        return ResponseEntity.status(Response.SC_OK).body(authResponse);
    }
}
