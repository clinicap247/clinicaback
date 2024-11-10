package com.kevin.gestionhistoriaclinica.repositories.shedule;

import java.util.List;
import java.util.Optional;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;

public interface IConsultingRoomRepository {
    List<ConsultingRoom> findAll();

    Optional<ConsultingRoom> findById(Long id);

    ConsultingRoom save(ConsultingRoom consultingRoom);

    void delete(Long id);
}
