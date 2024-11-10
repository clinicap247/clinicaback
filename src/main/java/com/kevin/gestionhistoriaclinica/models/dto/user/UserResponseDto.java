package com.kevin.gestionhistoriaclinica.models.dto.user;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private Boolean enabled;
    private UserType userType;
    private List<RoleResponseDto> role;
}
