package com.kevin.gestionhistoriaclinica.services.shedule;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleParams;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleResponse;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;

public interface IDoctorSheduleService {
    public List<DoctorSheduleResponse> findAll(DoctorSheduleParams params);

    public DoctorShedule findById(Long id);

    public DoctorShedule save(DoctorSheduleStoreDto dto);

    public DoctorShedule update(Long id, DoctorSheduleUpdateDto dto);

    public Boolean delete(Long id);

    public DoctorShedule findByIdWithException(Long id);
}
