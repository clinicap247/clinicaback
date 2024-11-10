package com.kevin.gestionhistoriaclinica.controllers.shedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;
import com.kevin.gestionhistoriaclinica.services.shedule.IConsultingRoomService;

@Controller
public class ConsultingRoomGraphqlController {

    @Autowired
    private IConsultingRoomService consultingRoomService;

    @QueryMapping
    public List<ConsultingRoom> consultingRooms() {
        return consultingRoomService.findAll();
    }

    @QueryMapping
    public ConsultingRoom consultingRoom(@Argument Long id) {
        return consultingRoomService.findById(id);
    }

    @MutationMapping
    public ConsultingRoom createConsultingRoom(@Argument ConsultingRoomStoreDto input) {
        return consultingRoomService.save(input);
    }

    @MutationMapping
    public ConsultingRoom updateConsultingRoom(@Argument Long id, @Argument ConsultingRoomUpdateDto input) {
        return consultingRoomService.update(id, input);
    }

    @MutationMapping
    public Boolean deleteConsultingRoom(@Argument Long id) {
        return consultingRoomService.delete(id);
    }
}
