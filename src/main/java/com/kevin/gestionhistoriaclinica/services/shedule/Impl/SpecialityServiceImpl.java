package com.kevin.gestionhistoriaclinica.services.shedule.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.shedule.SpecialityMapper;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.repositories.shedule.ISpecialityRepository;
import com.kevin.gestionhistoriaclinica.services.shedule.ISpecialityService;

@Service
public class SpecialityServiceImpl implements ISpecialityService {

    @Autowired
    private ISpecialityRepository specialityRepository;

    @Autowired
    private SpecialityMapper specialityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Speciality findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    @Transactional
    public Speciality save(SpecialityStoreDto dto) {
        Speciality speciality = specialityMapper.toEntity(dto);
        return specialityRepository.save(speciality);
    }

    @Override
    @Transactional
    public Speciality update(Long id, SpecialityUpdateDto dto) {
        Speciality speciality = findById(id);
        dto.setId(id);
        specialityMapper.toEntityForUpdate(speciality, dto);
        return specialityRepository.save(speciality);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        findById(id);
        specialityRepository.delete(id);
        return true;
    }

    @Override
    public Speciality findByIdWithException(Long id) {
        return specialityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad", "id", id));
    }
}
