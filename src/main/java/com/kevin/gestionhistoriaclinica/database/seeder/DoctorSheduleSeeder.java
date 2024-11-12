package com.kevin.gestionhistoriaclinica.database.seeder;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoreDto;
import com.kevin.gestionhistoriaclinica.services.shedule.IDoctorSheduleService;

@Component
public class DoctorSheduleSeeder implements Runnable {

    @Autowired
    private IDoctorSheduleService doctorSheduleService;

    @Override
    public void run() {
        Faker faker = new Faker();

        // Supongamos que ya tienes IDs válidos de doctor, especialidad y sala de
        // consulta.
        Long[] doctorIds = { 1L, 2L, 3L };
        Long[] specialityIds = { 1L, 2L, 3L, 4L, 5L };
        Long[] consultingRoomIds = { 1L, 2L, 3L };

        IntStream.range(0, 100).forEach(i -> {
            DoctorSheduleStoreDto sheduleDto = DoctorSheduleStoreDto.builder()
                    .dayOfWeek(faker.number().numberBetween(1, 7)) // Días de la semana del 1 al 7
                    .startTime("08:00") // Inicio fijo o aleatorio, puedes cambiarlo
                    .endTime("16:00") // Fin fijo o aleatorio, puedes cambiarlo
                    .slotDuration((long) (faker.number().numberBetween(10, 90))) // Duración entre 10 y 90
                    .doctorId(doctorIds[faker.number().numberBetween(0, doctorIds.length)])
                    .specialityId(specialityIds[faker.number().numberBetween(0, specialityIds.length)])
                    .consultingRoomId(consultingRoomIds[faker.number().numberBetween(0, consultingRoomIds.length)])
                    .build();

            doctorSheduleService.save(sheduleDto);
        });
    }
}
