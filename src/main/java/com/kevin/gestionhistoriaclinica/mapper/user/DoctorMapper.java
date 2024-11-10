package com.kevin.gestionhistoriaclinica.mapper.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorResponse;
import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;

@Component
public class DoctorMapper {

    @Autowired
    private UserMapper userMapper;

    public Doctor toEntity(DoctorStoreDto dto) {
        return Doctor.builder()
                .code(dto.getCode())
                .build();
    }

    public Doctor updateEntityFromDto(Doctor doctor, DoctorUpdateDto dto) {
        doctor.setId(dto.getId());
        doctor.setCode(dto.getCode());

        return doctor;
    }

    // Sin rol
    public DoctorResponse toResponseDto(Doctor doctor) {
        return DoctorResponse.builder()
                .id(doctor.getId())
                .code(doctor.getCode())
                .user(userMapper.toResponseDto(doctor.getUser()))
                .build();
    }

    public List<DoctorResponse> toResponseDtoList(List<Doctor> users) {
        return users.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}
