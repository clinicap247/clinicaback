package com.kevin.gestionhistoriaclinica.services.shedule;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleParams;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleResponse;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoredto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;

public interface IDoctorSheduleService {
    public List<DoctorSheduleResponse> findAll(DoctorSheduleParams params);

    public List<DoctorShedule> findAll();

    public DoctorShedule findById(Long id);

    public DoctorShedule save(DoctorSheduleStoredto dto);

    public DoctorShedule update(Long id, DoctorSheduleStoredto dto);

    public Boolean delete(Long id);

    public DoctorShedule findByIdWithException(Long id);
}
