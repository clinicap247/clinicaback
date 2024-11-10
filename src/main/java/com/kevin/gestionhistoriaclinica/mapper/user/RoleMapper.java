package com.kevin.gestionhistoriaclinica.mapper.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.user.RoleResponseDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;

@Component
public class RoleMapper {

    public RoleResponseDto toResponseDto(Role role) {
        return RoleResponseDto.builder().id(role.getId()).name(role.getName()).build();
    }

    public List<RoleResponseDto> toResponseDtoList(List<Role> roles) {
        return roles.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}
