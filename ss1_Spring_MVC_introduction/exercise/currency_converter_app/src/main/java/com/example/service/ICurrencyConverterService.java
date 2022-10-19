package com.example.service;

import org.springframework.stereotype.Service;

@Service
public interface ICurrencyConverterService {
    double calculate(double money);

}
