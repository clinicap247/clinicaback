package com.kevin.gestionhistoriaclinica.dao.shedule;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;

public interface ConsultingRoomJpaDao extends JpaRepository<ConsultingRoom, Long> {

}
