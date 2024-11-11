package com.kevin.gestionhistoriaclinica.database.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.repositories.shedule.ISpecialityRepository;

@Component
public class SpecialitySeeder implements Runnable {

    @Autowired
    private ISpecialityRepository specialityRepository;

    @Override
    public void run() {
        List<String> specialities = List.of(
                "Cardiologo", "Pediatra", "Dermatologo", "Oftalmologo", "Ginecologo", "Neurologo", "Oncologo",
                "Psiquiatra", "Traumatologo", "Urologo");

        for (String specialityName : specialities) {
            specialityRepository.findByName(specialityName).orElseGet(() -> {
                Speciality speciality = new Speciality(specialityName);
                return specialityRepository.save(speciality);
            });
        }

        System.out.println("Speciality seeder executed");
    }
}
