package com.kevin.gestionhistoriaclinica.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDto {
    private Long id;
    private String fullName;
    @Builder.Default
    private Boolean enabled = true;
    private String email;
    // private String password;
}
