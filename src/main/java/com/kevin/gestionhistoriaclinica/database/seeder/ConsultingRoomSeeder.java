package com.kevin.gestionhistoriaclinica.database.seeder;

import com.github.javafaker.Faker;
import com.kevin.gestionhistoriaclinica.services.shedule.IConsultingRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomStoreDto;

@Component
public class ConsultingRoomSeeder implements Runnable {

    @Autowired
    private IConsultingRoomService consultingRoomService;

    @Override
    public void run() {
        Faker faker = new Faker();

        IntStream.range(0, 10).forEach(i -> {
            ConsultingRoomStoreDto roomDto = ConsultingRoomStoreDto.builder()
                    .roomName("Room " + faker.number().numberBetween(1, 100))
                    .roomLocation(faker.address().fullAddress())
                    .build();

            consultingRoomService.save(roomDto);
        });
    }
}
