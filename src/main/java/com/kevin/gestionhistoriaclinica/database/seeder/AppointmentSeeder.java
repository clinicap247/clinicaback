package com.kevin.gestionhistoriaclinica.database.seeder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.models.enums.AppointmentStatus;
import com.kevin.gestionhistoriaclinica.services.shedule.IAppointmentService;
import com.kevin.gestionhistoriaclinica.services.shedule.IDoctorSheduleService;
import com.kevin.gestionhistoriaclinica.services.user.IPatientService;
import com.kevin.gestionhistoriaclinica.util.date.DateParser;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppointmentSeeder implements Runnable {
    private final IAppointmentService appointmentService;
    private final IPatientService patientService;
    private final IDoctorSheduleService doctorSheduleService;

    private final Random random = new Random();
    private final Faker faker = new Faker();

    @Override
    public void run() {
        List<DoctorShedule> doctorShedules = doctorSheduleService.findAll();
        List<Patient> patients = patientService.findAll();

        if (doctorShedules.isEmpty() || patients.isEmpty()) {
            System.out.println("No se pueden generar citas: faltan datos de DoctorShedule o Patient.");
            return;
        }

        IntStream.range(0, 200).forEach(i -> {
            try {
                AppointmentDto appointmentDto = generateRandomAppointmentDto(doctorShedules, patients,
                        LocalDate.parse("2024-11-01"), LocalDate.parse("2024-11-14"));
                appointmentService.save(appointmentDto);
            } catch (IllegalStateException e) {
                System.out.println("Slot ya reservado, omitiendo: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error al crear la cita: " + e.getMessage());
            }
        });
    }

    private AppointmentDto generateRandomAppointmentDto(List<DoctorShedule> doctorShedules, List<Patient> patients,
            LocalDate startDate, LocalDate endDate) {
        DoctorShedule randomDoctorShedule = doctorShedules.get(random.nextInt(doctorShedules.size()));
        Patient randomPatient = patients.get(random.nextInt(patients.size()));

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        LocalDate randomDate = startDate.plusDays(faker.number().numberBetween(0,
                (int) daysBetween + 1));
        // LocalDate randomDate =

        return AppointmentDto.builder()
                .appointmentDate(DateParser.parseDate(randomDate))
                .slotNumber(faker.number().numberBetween(1, randomDoctorShedule.getTotalSlots()))
                .status(AppointmentStatus.PENDING)
                .doctorSheduleId(randomDoctorShedule.getId())
                .patientId(randomPatient.getId())
                .build();
    }

}
