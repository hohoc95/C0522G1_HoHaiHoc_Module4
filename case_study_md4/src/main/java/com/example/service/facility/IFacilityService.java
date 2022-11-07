package com.example.service.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService{
    Facility findById(int id);

    Page<Facility> findByFacilityNameContaining (String name, Pageable pageable);

    void save (Facility facility);
    void update (Facility facility);
    void remove (int id);
}
