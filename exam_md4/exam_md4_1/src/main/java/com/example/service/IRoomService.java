package com.example.service;

import com.example.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<Room> findAll();

    Optional<Room> findById(Integer id);
//    Room findById(Integer id);

    Page<Room> findByRoom(Integer id, String name, String phone, Pageable pageable);

    void save(Room room);

    void update(Room room);

    void remove(int id);
}
