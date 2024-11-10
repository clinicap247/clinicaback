package com.kevin.gestionhistoriaclinica.repositories.shedule;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;

public interface IDoctorSheduleRepository {
    List<DoctorShedule> findAll();

    Optional<DoctorShedule> findById(Long id);

    DoctorShedule save(DoctorShedule doctorShedule);

    void delete(Long id);

    List<DoctorShedule> findByParams(DoctorSheduleParams params);
}
