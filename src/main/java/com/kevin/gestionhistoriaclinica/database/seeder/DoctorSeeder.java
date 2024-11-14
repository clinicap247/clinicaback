package com.kevin.gestionhistoriaclinica.database.seeder;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.kevin.gestionhistoriaclinica.models.dto.user.DoctorStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.services.user.IDoctorService;

@Component
public class DoctorSeeder implements Runnable {

    @Autowired
    private IDoctorService doctorService;

    @Override
    public void run() {
        Faker faker = new Faker();

        IntStream.range(0, 30).forEach(i -> {
            DoctorStoreDto doctorDto = DoctorStoreDto.builder()
                    .code(faker.idNumber().valid())
                    .user(UserDto.builder()
                            .fullName(faker.name().fullName())
                            .email(faker.internet().emailAddress())
                            .password("password")
                            .enabled(true)
                            .build())
                    .build();

            doctorService.save(doctorDto);
        });
    }
}
