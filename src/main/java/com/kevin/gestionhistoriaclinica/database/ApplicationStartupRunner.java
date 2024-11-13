package com.kevin.gestionhistoriaclinica.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kevin.gestionhistoriaclinica.database.seeder.SeederRunner;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    @Autowired
    private SeederRunner seederRunner;

    @Override
    public void run(String... args) throws Exception {
        String runAllSeeders = System.getenv("RUN_ALL_SEEDERS");

        if ("true".equalsIgnoreCase(runAllSeeders)) {
            // seederRunner.runAllSeeders();
        } else {
            System.out.println("Seeder execution skipped.");
        }
    }
}
