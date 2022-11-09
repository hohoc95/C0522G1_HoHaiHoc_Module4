package com.example.service.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService{
    Facility findById(int id);

    List<Facility> findAll();

    Page<Facility> findByFacilityNameContaining (String name, String facilityType, Pageable pageable);


    void save (Facility facility);
    void update (Facility facility);
    void remove (int id);
}
