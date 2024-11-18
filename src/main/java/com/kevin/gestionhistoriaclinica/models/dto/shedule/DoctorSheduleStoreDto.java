package com.kevin.gestionhistoriaclinica.models.dto.shedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DoctorSheduleStoredto {
    private Long id;
    private Integer dayOfWeek;
    private String startTime;
    private String endTime;
    private Long slotDuration;
    @Builder.Default
    private Boolean status = true;

    // FK
    private Long doctorId;
    private Long specialityId;
    private Long consultingRoomId;
}
