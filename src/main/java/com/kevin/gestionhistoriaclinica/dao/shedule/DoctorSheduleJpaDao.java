package com.kevin.gestionhistoriaclinica.dao.shedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;

public interface DoctorSheduleJpaDao
        extends JpaRepository<DoctorShedule, Long>, JpaSpecificationExecutor<DoctorShedule> {
}
