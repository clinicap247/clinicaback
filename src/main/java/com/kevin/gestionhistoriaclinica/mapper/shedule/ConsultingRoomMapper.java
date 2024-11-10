package com.kevin.gestionhistoriaclinica.mapper.shedule;

import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;

@Component
public class ConsultingRoomMapper {
    public ConsultingRoom toEntity(ConsultingRoomStoreDto dto) {
        ConsultingRoom consultingRoom = new ConsultingRoom();
        consultingRoom.setRoomName(dto.getRoomName());
        consultingRoom.setRoomLocation(dto.getRoomLocation());
        return consultingRoom;
    }

    public ConsultingRoom toEntity(ConsultingRoom consultingRoom, ConsultingRoomUpdateDto dto) {
        consultingRoom.setId(dto.getId());
        consultingRoom.setRoomName(dto.getRoomName());
        consultingRoom.setRoomLocation(dto.getRoomLocation());
        return consultingRoom;
    }
}
