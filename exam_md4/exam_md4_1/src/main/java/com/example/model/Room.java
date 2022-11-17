package com.example.model;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String roomName;
    private String roomPhone;
    private String dateOfStart;
    private String roomNote;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name= "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;

    public Room() {
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPhone() {
        return roomPhone;
    }

    public void setRoomPhone(String roomPhone) {
        this.roomPhone = roomPhone;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getRoomNote() {
        return roomNote;
    }

    public void setRoomNote(String roomNote) {
        this.roomNote = roomNote;
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
}
