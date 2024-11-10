package com.kevin.gestionhistoriaclinica.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorUpdateDto {
    private Long id;
    private String code;
    private UserDto user;
}
