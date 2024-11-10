package com.kevin.gestionhistoriaclinica.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DoctorStoreDto {
    private String code;
    private UserDto user;
}
