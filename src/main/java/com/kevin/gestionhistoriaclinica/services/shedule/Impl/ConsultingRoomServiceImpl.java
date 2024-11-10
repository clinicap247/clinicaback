package com.kevin.gestionhistoriaclinica.services.shedule.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.gestionhistoriaclinica.exception.ResourceNotFoundException;
import com.kevin.gestionhistoriaclinica.mapper.shedule.ConsultingRoomMapper;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomStoreDto;
import com.kevin.gestionhistoriaclinica.models.dto.shedule.ConsultingRoomUpdateDto;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;
import com.kevin.gestionhistoriaclinica.repositories.shedule.IConsultingRoomRepository;
import com.kevin.gestionhistoriaclinica.services.shedule.IConsultingRoomService;

@Service
public class ConsultingRoomServiceImpl implements IConsultingRoomService {

    @Autowired
    private IConsultingRoomRepository consultingRoomRepository;

    @Autowired
    private ConsultingRoomMapper consultingRoomMapper;

    @Override
    public List<ConsultingRoom> findAll() {
        return consultingRoomRepository.findAll();
    }

    @Override
    public ConsultingRoom findById(Long id) {
        return findByIdWithException(id);
    }

    @Override
    public ConsultingRoom save(ConsultingRoomStoreDto dto) {
        ConsultingRoom consultingRoom = consultingRoomMapper.toEntity(dto);
        return consultingRoomRepository.save(consultingRoom);
    }

    @Override
    public ConsultingRoom update(Long id, ConsultingRoomUpdateDto dto) {
        ConsultingRoom consultingRoom = findById(id);
        dto.setId(id);
        consultingRoom = consultingRoomMapper.toEntity(consultingRoom, dto);
        return consultingRoomRepository.save(consultingRoom);
    }

    @Override
    public Boolean delete(Long id) {
        consultingRoomRepository.delete(id);
        return true;
    }

    @Override
    public ConsultingRoom findByIdWithException(Long id) {
        return consultingRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación de Consulta", "id", id));
    }
}
