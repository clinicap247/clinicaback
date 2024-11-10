package com.kevin.gestionhistoriaclinica.models.dto.shedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialityResponseDto {
    private Long id;
    private String name;
}
