package com.kevin.gestionhistoriaclinica.services.user.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.user.PatientMapper;
import com.kevin.gestionhistoriaclinica.models.dto.user.PatientDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;
import com.kevin.gestionhistoriaclinica.repositories.user.IPatientRepository;
import com.kevin.gestionhistoriaclinica.services.user.IPatientService;
import com.kevin.gestionhistoriaclinica.services.user.IRoleService;
import com.kevin.gestionhistoriaclinica.services.user.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    final private IPatientRepository patientRepository;
    // Service
    final private IUserService userService;
    final private IRoleService roleService;
    final private PatientMapper patientMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @Override
    public Patient findById(Long id) {
        Patient patient = findByIdWithException(id);
        return patient;
    }

    @Override
    @Transactional
    public Patient save(PatientDto dto) {
        // Obtenr rol de doctor
        Role role = roleService.getRolePatient();

        System.out.println("Rol " + role);

        // Crear usuario si se proporciona
        UserDto userDto = dto.getUser();
        User userSaved = userService.save(userDto, role);

        Patient patient = patientMapper.toEntity(dto, userSaved);

        return patientRepository.save(patient);
    }

    @Override
    @Transactional
    public Patient update(Long id, PatientDto dto) {
        Patient patient = findByIdWithException(id);

        dto.setId(id);
        patient = patientMapper.updateEntityFromDto(patient, dto);

        if (dto.getUser() != null && dto.getUser().getId() != null) {
            User user = userService.update(dto.getUser().getId(), dto.getUser());
            patient.setUser(user);
        }

        return patientRepository.save(patient);
    }

    @Transactional(readOnly = true)
    private Patient findByIdWithException(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente", "id", id));
    }

}
