package com.kevin.gestionhistoriaclinica.services.shedule.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.shedule.AppointmentMapper;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.AppointmentParams;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Appointment;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.models.entities.user.Patient;
import com.kevin.gestionhistoriaclinica.repositories.shedule.IAppointmentRepository;
import com.kevin.gestionhistoriaclinica.services.shedule.IAppointmentService;
import com.kevin.gestionhistoriaclinica.services.shedule.IDoctorSheduleService;
import com.kevin.gestionhistoriaclinica.services.user.IPatientService;
import com.kevin.gestionhistoriaclinica.util.date.DateParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;
    // Service
    private final IPatientService patientService;
    private final IDoctorSheduleService doctorSheduleService;
    // Mapper
    private final AppointmentMapper appointmentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> findAll(AppointmentParams params) {
        return appointmentRepository.findAll(params);
    }

    @Override
    @Transactional(readOnly = true)
    public Appointment findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    @Transactional
    public Appointment save(AppointmentDto dto) {
        DoctorShedule doctorShedule = doctorSheduleService.findById(dto.getDoctorSheduleId());
        existsAppointment(dto, doctorShedule);

        Patient patient = patientService.findById(dto.getPatientId());

        Appointment appointment = appointmentMapper.toEntity(dto, patient, doctorShedule);

        return appointmentRepository.save(appointment);
    }

    @Override
    @Transactional
    public Appointment update(Long id, AppointmentDto dto) {
        Appointment appointment = findByIdWithException(id);
        dto.setId(id);

        appointment = appointmentMapper.updateEntityFromDto(dto, appointment);

        return appointmentRepository.save(appointment);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        appointmentRepository.delete(id);
        return true;
    }

    private Appointment findByIdWithException(Long id) {
        return appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ficha de atención", "id", id));
    }

    private Boolean existsAppointment(AppointmentDto dto, DoctorShedule doctorShedule) {
        Optional<Appointment> appointment = appointmentRepository.find(
                doctorShedule,
                dto.getSlotNumber(),
                DateParser.parseDate(LocalDate.now()));

        if (appointment.isPresent()) {
            throw new IllegalStateException("El cupo ya está reservado para este horario.");
        }

        return true;
    }

}
