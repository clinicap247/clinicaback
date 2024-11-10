package com.kevin.gestionhistoriaclinica.services.shedule;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.SpecialityUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;

public interface ISpecialityService {
    public List<Speciality> findAll();

    public Speciality findById(Long id);

    public Speciality save(SpecialityStoreDto dto);

    public Speciality update(Long id, SpecialityUpdateDto dto);

    public Boolean delete(Long id);

    public Speciality findByIdWithException(Long id);
}
