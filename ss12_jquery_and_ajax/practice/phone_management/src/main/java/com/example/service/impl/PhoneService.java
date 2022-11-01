package com.example.service.impl;

import com.example.model.Phone;
import com.example.repository.IPhoneRepository;
import com.example.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository iPhoneRepository;

    @Override
    public List<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public void save(Phone phone) {
        iPhoneRepository.save(phone);
    }

    @Override
    public void update(Phone phone) {
        iPhoneRepository.save(phone);
    }
}
