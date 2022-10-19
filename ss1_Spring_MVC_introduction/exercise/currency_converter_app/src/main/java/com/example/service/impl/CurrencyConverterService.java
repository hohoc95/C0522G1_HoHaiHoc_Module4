package com.example.service.impl;

import com.example.service.ICurrencyConverterService;

public class CurrencyConverterService implements ICurrencyConverterService {
    @Override
    public double calculate(double money) {
        return money * 23000;
    }
}
