package com.kevin.gestionhistoriaclinica.models.dto.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDto {
    private Long id;
    private String ic;
    private String address;
    private String phone;
    private Date birthdate;
}
