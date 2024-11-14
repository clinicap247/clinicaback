package com.kevin.gestionhistoriaclinica.database.seeder;

import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.kevin.gestionhistoriaclinica.models.dto.user.PatientDto;
import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.models.enums.UserType;
import com.kevin.gestionhistoriaclinica.services.user.IPatientService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PatientSeeder implements Runnable {

    private final IPatientService patientService;

    @Override
    public void run() {
        Faker faker = new Faker();

        IntStream.range(0, 20).forEach(i -> {
            patientService.save(PatientDto.builder()
                    .ic(faker.idNumber().valid())
                    .address(faker.address().fullAddress())
                    .phone(faker.phoneNumber().cellPhone())
                    .birthdate("12-01-2000")
                    .user(UserDto.builder()
                            .fullName(faker.name().fullName())
                            .email(faker.internet().emailAddress())
                            .password("password")
                            .enabled(true)
                            .userType(UserType.PATIENT)
                            .build())
                    .build());
        });
    }
}
