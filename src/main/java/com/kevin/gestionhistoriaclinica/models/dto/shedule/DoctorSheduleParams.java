package com.kevin.gestionhistoriaclinica.models.dto.shedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorSheduleParams {
    private Long doctorId;
    private Long specialityId;
    private Long consultingRoomId;
    private Integer dayOfWeek;
    private Boolean status;
}
