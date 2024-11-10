package com.kevin.gestionhistoriaclinica.models.dto.shedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ConsultingRoomStoreDto {
    private String roomName;
    private String roomLocation;
}
