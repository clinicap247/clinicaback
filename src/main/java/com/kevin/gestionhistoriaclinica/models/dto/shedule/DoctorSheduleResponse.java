package com.kevin.gestionhistoriaclinica.models.dto.shedule;

import java.util.ArrayList;
import java.util.List;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorSheduleResponse {
    private Long id;
    private Integer dayOfWeek;
    private String startTime;
    private String endTime;
    private Long slotDuration;
    private Integer totalSlots;
    @Builder.Default
    private Boolean status = true;

    private Doctor doctor;
    private Speciality speciality;
    private ConsultingRoom consultingRoom;

    // array de cupos reservados
    @Builder.Default
    private List<Integer> reservedSlots = new ArrayList<>();
}
