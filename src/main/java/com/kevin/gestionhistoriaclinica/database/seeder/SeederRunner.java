package com.kevin.gestionhistoriaclinica.database.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeederRunner {

    @Autowired
    private RoleSeeder roleSeeder;

    @Autowired
    private SpecialitySeeder specialitySeeder;

    @Autowired
    private ConsultingRoomSeeder consultingRoomSeeder;

    @Autowired
    private DoctorSeeder doctorSeeder;

    @Autowired
    private DoctorSheduleSeeder doctorSheduleSeeder;

    public void runAllSeeders() {
        try {
            // System.out.println("Running RoleSeeder...");
            // roleSeeder.run();
            // System.out.println("RoleSeeder completed");

            // System.out.println("Running SpecialitySeeder...");
            // specialitySeeder.run();
            // System.out.println("SpecialitySeeder completed");

            // System.out.println("Running ConsultingRoomSeeder...");
            // consultingRoomSeeder.run();
            // System.out.println("ConsultingRoomSeeder completed");

            // System.out.println("Running DoctorSeeder...");
            // doctorSeeder.run();
            // System.out.println("DoctorSeeder completed");

            // System.out.println("Running DoctorSheduleSeeder...");
            // doctorSheduleSeeder.run();
            // System.out.println("DoctorSheduleSeeder completed");

        } catch (Exception e) {
            System.err.println("Error running seeders: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
