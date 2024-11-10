package com.kevin.gestionhistoriaclinica.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {
    @Builder.Default
    private Long id = null;
    private String ic;
    private String address;
    private String phone;
    private String birthdate;
    private UserDto user;
}
