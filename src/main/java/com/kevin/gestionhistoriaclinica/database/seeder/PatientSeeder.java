package com.kevin.gestionhistoriaclinica.database.seeder;

import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.kevin.gestionhistoriaclinica.models.dto.user.PatientDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.services.user.IPatientService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PatientSeeder {

    private final IPatientService patientService;

    public void run() {
        Faker faker = new Faker();

        IntStream.range(0, 10).forEach(i -> {
            patientService.save(PatientDto.builder()
                    .ic(faker.idNumber().valid())
                    .address(faker.address().fullAddress())
                    .phone(faker.phoneNumber().cellPhone())
                    .birthdate("12-01-2000")
                    .user(UserDto.builder()
                            .fullName(faker.name().fullName())
                            .email(faker.internet().emailAddress())
                            .password(faker.internet().password())
                            .enabled(true)
                            .build())
                    .build());
        });
    }
}
