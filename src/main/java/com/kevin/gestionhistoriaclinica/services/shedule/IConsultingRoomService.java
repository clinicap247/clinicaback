package com.kevin.gestionhistoriaclinica.services.shedule;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;

public interface IConsultingRoomService {
    List<ConsultingRoom> findAll();

    ConsultingRoom findById(Long id);

    ConsultingRoom save(ConsultingRoomStoreDto dto);

    ConsultingRoom update(Long id, ConsultingRoomUpdateDto dto);

    Boolean delete(Long id);

    ConsultingRoom findByIdWithException(Long id);
}
