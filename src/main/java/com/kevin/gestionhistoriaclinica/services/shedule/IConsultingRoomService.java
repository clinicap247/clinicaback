package com.kevin.gestionhistoriaclinica.services.shedule;

import java.util.List;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;

public interface IConsultingRoomService {
    public List<ConsultingRoom> findAll();

    public ConsultingRoom findById(Long id);

    public ConsultingRoom save(ConsultingRoomStoreDto dto);

    public ConsultingRoom update(Long id, ConsultingRoomUpdateDto dto);

    public Boolean delete(Long id);

    public ConsultingRoom findByIdWithException(Long id);
}
