package com.kevin.gestionhistoriaclinica.models.dto.user;

import com.kevin.gestionhistoriaclinica.models.entities.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private User user;
    private String token;
}
