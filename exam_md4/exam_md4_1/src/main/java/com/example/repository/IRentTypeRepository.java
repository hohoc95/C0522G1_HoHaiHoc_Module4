package com.example.repository;

import com.example.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {

    List<RentType> findAll();

}
