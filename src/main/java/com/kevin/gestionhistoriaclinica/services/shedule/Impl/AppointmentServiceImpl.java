package com.kevin.gestionhistoriaclinica.services.shedule.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

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
    public List<Appointment> findAll(AppointmentParams params) {
        return appointmentRepository.findAll(params);
    }

    @Override
    public Appointment findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    public Appointment save(AppointmentDto dto) {
        Patient patient = patientService.findById(dto.getPatientId());
        DoctorShedule doctorShedule = doctorSheduleService.findById(dto.getDoctorSheduleId());

        Appointment appointment = appointmentMapper.toEntity(dto, patient, doctorShedule);

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long id, AppointmentDto dto) {
        Appointment appointment = findByIdWithException(id);
        dto.setId(id);

        appointment = appointmentMapper.updateEntityFromDto(dto, appointment);

        return appointmentRepository.save(appointment);
    }

    @Override
    public Boolean delete(Long id) {
        appointmentRepository.delete(id);
        return true;
    }

    private Appointment findByIdWithException(Long id) {
        return appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ficha de atención", "id", id));
    }
}
