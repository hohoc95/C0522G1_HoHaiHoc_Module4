package com.example.repository;

import com.example.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAll();

    Room findById(int id);
    @Query(value = "select r.* from room r join rent_type rt on r.rent_type_id = rt.rent_type_id where r.room_id like %:id% and r.room_name like %:name% and r.room_phone like %:phone% and r.is_delete = 0",
    nativeQuery = true,
    countQuery = "select r.* from room r join rent_type rt on r.rent_type_id = rt.rent_type_id where r.room_id like %:id% and r.room_name like %:name% and r.room_phone like %:phone% and r.is_delete = 0")
    Page<Room> findByRoom(@Param("id") Integer id,
                          @Param("name") String name,
                          @Param("phone") String phone,
                          Pageable pageable);
}
