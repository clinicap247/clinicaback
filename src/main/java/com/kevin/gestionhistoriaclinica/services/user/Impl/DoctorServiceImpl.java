package com.kevin.gestionhistoriaclinica.services.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.user.DoctorMapper;
import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorUpdateDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;
import com.kevin.gestionhistoriaclinica.models.enums.UserType;
import com.kevin.gestionhistoriaclinica.repositories.user.IDoctorRepository;
import com.kevin.gestionhistoriaclinica.services.user.IDoctorService;
import com.kevin.gestionhistoriaclinica.services.user.IRoleService;
import com.kevin.gestionhistoriaclinica.services.user.IUserService;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();

        System.out.println("Doctores " + doctors);

        return doctors;
    }

    @Override
    @Transactional(readOnly = true)
    public Doctor findById(Long id) {
        Doctor doctor = findByIdWithException(id);
        System.out.println("Doctor " + doctor);
        return doctor;
    }

    @Override
    @Transactional
    public Doctor save(DoctorStoreDto dto) {
        // Obtenr rol de doctor
        Role role = roleService.getRoleDoctor();

        System.out.println("Rol " + role);

        // Crear usuario si se proporciona
        UserDto userDto = dto.getUser();
        userDto.setUserType(UserType.DOCTOR);
        User userSaved = userService.save(userDto, role);

        Doctor doctor = doctorMapper.toEntity(dto);
        doctor.setUser(userSaved);

        return doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public Doctor update(Long id, DoctorUpdateDto dto) {
        Doctor doctor = findByIdWithException(id);

        dto.setId(id);
        doctor = doctorMapper.updateEntityFromDto(doctor, dto);

        if (dto.getUser() != null && dto.getUser().getId() != null) {
            User user = userService.update(dto.getUser().getId(), dto.getUser());
            doctor.setUser(user);
            System.out.println("Doctor actualizado ");
        }

        return doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        Doctor doctor = findByIdWithException(id);
        System.out.println(doctor);
        doctorRepository.delete(id);
        userService.delete(doctor.getUser().getId());
        return true;
    }

    private Doctor findByIdWithException(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
    }
}
