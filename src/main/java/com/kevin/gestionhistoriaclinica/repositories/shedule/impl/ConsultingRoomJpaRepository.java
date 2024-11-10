package com.kevin.gestionhistoriaclinica.repositories.shedule.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kevin.gestionhistoriaclinica.dao.shedule.ConsultingRoomJpaDao;
import com.kevin.gestionhistoriaclinica.models.entities.shedule.ConsultingRoom;
import com.kevin.gestionhistoriaclinica.repositories.shedule.IConsultingRoomRepository;

@Repository
public class ConsultingRoomJpaRepository implements IConsultingRoomRepository {

    @Autowired
    private ConsultingRoomJpaDao consultingRoomDao;

    @Override
    public List<ConsultingRoom> findAll() {
        return consultingRoomDao.findAll();
    }

    @Override
    public Optional<ConsultingRoom> findById(Long id) {
        return consultingRoomDao.findById(id);
    }

    @Override
    public ConsultingRoom save(ConsultingRoom consultingRoom) {
        return consultingRoomDao.save(consultingRoom);
    }

    @Override
    public void delete(Long id) {
        consultingRoomDao.deleteById(id);
    }

}
