package com.kevin.gestionhistoriaclinica.services.shedule.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.shedule.DocotorSheduleMapper;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleParams;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleResponse;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.DoctorSheduleStoreDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.DoctorShedule;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.Speciality;
import com.kevin.gestionhistoriaclinica.models.entities.user.Doctor;
import com.kevin.gestionhistoriaclinica.repositories.shedule.IDoctorSheduleRepository;
import com.kevin.gestionhistoriaclinica.services.shedule.IConsultingRoomService;
import com.kevin.gestionhistoriaclinica.services.shedule.IDoctorSheduleService;
import com.kevin.gestionhistoriaclinica.services.shedule.ISpecialityService;
import com.kevin.gestionhistoriaclinica.services.user.IDoctorService;
import com.kevin.gestionhistoriaclinica.util.time.TimeSlotCalculator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorSheduleServiceImpl implements IDoctorSheduleService {
    // Repository
    final private IDoctorSheduleRepository doctorSheduleRepository;
    // Services
    final private ISpecialityService specialityService;
    final private IConsultingRoomService consultingRoomService;
    final private IDoctorService doctorService;
    // Mapper
    final private DocotorSheduleMapper doctorSheduleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DoctorSheduleResponse> findAll(DoctorSheduleParams params) {
        List<DoctorShedule> doctorShedules = doctorSheduleRepository.findByParams(params);
        return doctorSheduleMapper.toResponseList(doctorShedules);
    }

    @Override
    public List<DoctorShedule> findAll() {
        return doctorSheduleRepository.findAll();
    }

    @Override
    public DoctorShedule findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    @Transactional
    public DoctorShedule save(DoctorSheduleStoreDto dto) {
        Doctor doctor = doctorService.findById(dto.getDoctorId());
        Speciality speciality = specialityService.findById(dto.getSpecialityId());
        ConsultingRoom consultingRoom = consultingRoomService.findById(dto.getConsultingRoomId());

        // Calcular la cantidad de cupos
        int totalSlots = (int) TimeSlotCalculator.calculateSlots(
                dto.getStartTime(),
                dto.getEndTime(),
                dto.getSlotDuration());

        DoctorShedule doctorShedule = doctorSheduleMapper.toEntity(dto, totalSlots, doctor, speciality, consultingRoom);

        return doctorSheduleRepository.save(doctorShedule);
    }

    @Override
    @Transactional
    public DoctorShedule update(Long id, DoctorSheduleStoreDto dto) {
        DoctorShedule doctorShedule = findByIdWithException(id);

        Doctor doctor = doctorService.findById(dto.getDoctorId());
        Speciality speciality = specialityService.findById(dto.getSpecialityId());
        ConsultingRoom consultingRoom = consultingRoomService.findById(dto.getConsultingRoomId());

        int totalSlots = (int) TimeSlotCalculator.calculateSlots(
                dto.getStartTime(),
                dto.getEndTime(),
                dto.getSlotDuration());

        dto.setId(id);
        doctorShedule = doctorSheduleMapper.updateEntityFromDto(dto, doctorShedule, totalSlots, doctor, speciality,
                consultingRoom);

        return doctorSheduleRepository.save(doctorShedule);

    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional(readOnly = true)
    public DoctorShedule findByIdWithException(Long id) {
        return doctorSheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad", "id", id));
    }

}
