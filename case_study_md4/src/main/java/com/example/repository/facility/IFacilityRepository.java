package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility, Integer > {
    List<Facility> findAll();
    Facility findById(int id);

    @Query(value = " select * from facility join facility_type " +
            " on facility.facility_type_id = facility_type.facility_type_id " +
            " where " +
            " facility.facility_name like %:name% " +
            " and " +
            " facility_type.facility_type_name like %:facilityType% " +
            " and " +
            " facility.is_delete = 0 ",
            nativeQuery = true)
    Page<Facility> findByFacilityNameContaining(@Param("name")String name,
                                                @Param("facilityType") String facilityType, Pageable pageable);

//    @Query(value = " select * from facility join facility_type " +
//            " on facility.facility_type_id = facility_type.facility_type_id " +
//            " where  " +
//            " facility.facility_name like %:name%" +
//            " and " +
//            " facility_type.facility_type_name like %:facilityType%" +
//            " and " +
//            " facility.is_delete = 0 ",
//            nativeQuery = true)
//    Page<Facility> findByFacilityNameContaining(@Param("name")String name,
//                                                @Param("facilityType") String facilityType, Pageable pageable);
}
