package com.example.dto;

import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private int facilityId;

    @NotBlank(message = "Tên dịch vụ không được để trống.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên dịch vụ không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String facilityName;

    @NotBlank(message = "không được để trống.")
    private String facilityArea;

    @NotBlank(message = "không được để trống.")
    private String rentCost;

    @NotBlank(message = "không được để trống.")
    private String maxPeople;

    @NotBlank(message = "không được để trống.")
    private String standardRoom;

    @NotBlank(message = "không được để trống.")
    private String descriptionOtherConvenience;

    @NotBlank(message = "không được để trống.")
    private String poolArea;

    @NotBlank(message = "không được để trống.")
    private String numberOfFloors;

    @NotBlank(message = "không được để trống.")
    private String facilityFree;
    private boolean isDelete;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(String facilityArea) {
        this.facilityArea = facilityArea;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
    }
}
