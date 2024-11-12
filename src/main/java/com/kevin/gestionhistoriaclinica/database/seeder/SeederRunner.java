package com.kevin.gestionhistoriaclinica.database.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SeederRunner {

    private final RoleSeeder roleSeeder;
    private final SpecialitySeeder specialitySeeder;
    private final ConsultingRoomSeeder consultingRoomSeeder;
    private final DoctorSeeder doctorSeeder;
    private final DoctorSheduleSeeder doctorSheduleSeeder;
    private final PatientSeeder patientSeeder;

    public void runAllSeeders() {
        try {
            System.out.println("Running RoleSeeder...");
            roleSeeder.run();
            System.out.println("RoleSeeder completed");

            System.out.println("Running SpecialitySeeder...");
            specialitySeeder.run();
            System.out.println("SpecialitySeeder completed");

            System.out.println("Running ConsultingRoomSeeder...");
            consultingRoomSeeder.run();
            System.out.println("ConsultingRoomSeeder completed");

            System.out.println("Running DoctorSeeder...");
            doctorSeeder.run();
            System.out.println("DoctorSeeder completed");

            System.out.println("Running DoctorSheduleSeeder...");
            doctorSheduleSeeder.run();
            System.out.println("DoctorSheduleSeeder completed");

            System.out.println("Running PatientSeeder...");
            patientSeeder.run();
            System.out.println("PatientSeeder completed");

        } catch (Exception e) {
            System.err.println("Error running seeders: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
