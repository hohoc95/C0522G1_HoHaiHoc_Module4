package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility, Integer > {
    List<Facility> findAll();
    Facility findById(int id);

    Page<Facility> findByFacilityNameContaining(String name, Pageable pageable);
}
