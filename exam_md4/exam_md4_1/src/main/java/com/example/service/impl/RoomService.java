package com.example.service.impl;

import com.example.model.Room;
import com.example.repository.IRoomRepository;
import com.example.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private IRoomRepository iRoomRepository;

    @Override
    public List<Room> findAll() {
        return iRoomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return iRoomRepository.findById(id);
    }

    @Override
    public Page<Room> findByRoom(Integer id, String name, String phone, Pageable pageable) {
        return iRoomRepository.findByRoom(id,name, phone, pageable);
    }

    @Override
    public void save(Room room) {
        iRoomRepository.save(room);
    }

    @Override
    public void update(Room room) {
        iRoomRepository.save(room);
    }

    @Override
    public void remove(int id) {
        iRoomRepository.deleteById(id);
    }


}
