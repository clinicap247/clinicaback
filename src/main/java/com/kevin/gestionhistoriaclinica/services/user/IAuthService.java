package com.kevin.gestionhistoriaclinica.services.user;

import com.kevin.gestionhistoriaclinica.models.dto.user.LoginDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.AuthResponse;

public interface IAuthService {
    public AuthResponse login(LoginDto authDto);
}
