package com.kevin.gestionhistoriaclinica.models.dto.user;

import com.kevin.gestionhistoriaclinica.models.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDto {
    private Long id;
    private String fullName;
    @Builder.Default
    private Boolean enabled = true;
    private String email;
    private String password;
    private UserType userType;
}
