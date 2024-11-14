package com.kevin.gestionhistoriaclinica.database.seeder;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoreDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;
import com.kevin.gestionhistoriaclinica.services.shedule.IConsultingRoomService;
import com.kevin.gestionhistoriaclinica.services.shedule.IDoctorSheduleService;
import com.kevin.gestionhistoriaclinica.services.shedule.ISpecialityService;
import com.kevin.gestionhistoriaclinica.services.user.IDoctorService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DoctorSheduleSeeder implements Runnable {

    private final IDoctorSheduleService doctorSheduleService;
    private final IDoctorService doctorService;
    private final ISpecialityService specialityService;
    private final IConsultingRoomService consultingRoomService;

    private final Random random = new Random();
    private final Faker faker = new Faker();

    @Override
    public void run() {
        List<Doctor> doctors = doctorService.findAll();
        List<Speciality> specialities = specialityService.findAll();
        List<ConsultingRoom> consultingRooms = consultingRoomService.findAll();

        if (doctors.isEmpty() || specialities.isEmpty() || consultingRooms.isEmpty()) {
            System.out.println(
                    "No se pueden generar horarios: faltan datos de doctores, especialidades o salas de consulta.");
            return;
        }

        IntStream.range(0, 200).forEach(i -> {
            try {
                DoctorSheduleStoreDto sheduleDto = generateRandomDoctorShedule(doctors, specialities, consultingRooms);
                doctorSheduleService.save(sheduleDto);
            } catch (Exception e) {
                System.err.println("Error al crear el horario: " + e.getMessage());
            }
        });
    }

    private DoctorSheduleStoreDto generateRandomDoctorShedule(List<Doctor> doctors, List<Speciality> specialities,
            List<ConsultingRoom> consultingRooms) {
        Doctor randomDoctor = doctors.get(random.nextInt(doctors.size()));
        Speciality randomSpeciality = specialities.get(random.nextInt(specialities.size()));
        ConsultingRoom randomConsultingRoom = consultingRooms.get(random.nextInt(consultingRooms.size()));

        return DoctorSheduleStoreDto.builder()
                .dayOfWeek(faker.number().numberBetween(1, 7)) // Días de la semana del 1 al 7
                .startTime("08:00")
                .endTime("16:00")
                .slotDuration((long) faker.number().numberBetween(10, 90)) // Duración entre 10 y 90 minutos
                .doctorId(randomDoctor.getId())
                .specialityId(randomSpeciality.getId())
                .consultingRoomId(randomConsultingRoom.getId())
                .build();
    }
}
