package com.kevin.gestionhistoriaclinica.mapper.shedule;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;

@Component
public class SpecialityMapper {
    public Speciality toEntity(SpecialityStoreDto dto) {
        return new Speciality(dto.getName());
    }

    public Speciality toEntityForUpdate(Speciality speciality, SpecialityUpdateDto specialityUpdateDto) {
        speciality.setId(specialityUpdateDto.getId());
        speciality.setName(specialityUpdateDto.getName());

        return speciality;
    }

    // public SpecialityResponseDto toResponseDto(Speciality speciality) {
    // return
    // SpecialityResponseDto.builder().id(speciality.getId()).name(speciality.getName()).build();
    // }

    // public List<SpecialityResponseDto> toResponseDtoList(List<Speciality> users)
    // {
    // return users.stream()
    // .map(this::toResponseDto)
    // .collect(Collectors.toList());
    // }
}
