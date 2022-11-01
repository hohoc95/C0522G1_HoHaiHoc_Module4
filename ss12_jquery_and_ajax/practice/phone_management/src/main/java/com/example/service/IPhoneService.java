package com.example.service;

import com.example.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();
    void save(Phone phone);
    void update(Phone phone);
}
