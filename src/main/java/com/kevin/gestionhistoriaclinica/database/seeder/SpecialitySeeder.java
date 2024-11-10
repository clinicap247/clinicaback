package com.kevin.gestionhistoriaclinica.database.seeder;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.repositories.shedule.ISpecialityRepository;

@Component
public class SpecialitySeeder implements Runnable {

    @Autowired
    private ISpecialityRepository specialityRepository;

    @Override
    public void run() {
        Faker faker = new Faker();

        IntStream.range(0, 10).forEach(i -> {
            String specialityName = faker.medical().diseaseName();
            specialityRepository.findByName(specialityName).orElseGet(() -> {
                Speciality speciality = new Speciality(specialityName);
                return specialityRepository.save(speciality);
            });
        });

        System.out.println("Speciality seeder executed");
    }
}
