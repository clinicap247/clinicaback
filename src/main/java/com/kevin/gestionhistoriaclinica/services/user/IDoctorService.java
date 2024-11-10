package com.kevin.gestionhistoriaclinica.services.user;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;

public interface IDoctorService {
    List<Doctor> findAll();

    Doctor findById(Long id);

    Doctor save(DoctorStoreDto dto);

    Doctor update(Long id, DoctorUpdateDto dto);

    Boolean delete(Long id);
}
