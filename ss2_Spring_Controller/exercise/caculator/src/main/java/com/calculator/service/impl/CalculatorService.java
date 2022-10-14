package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculation(String number1, String number2, String operator) {
        try {

            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            double result = 0;
            switch (operator) {
                case "Addition":
                    result = num1 + num2;
                    break;
                case "Subtraction":
                    result = num1 - num2;
                    break;
                case "Multiplication":
                    result = num1 * num2;
                    break;
                case "Division":
                    if (num2 == 0) {
                        return "không thể chia cho 0!!";
                    } else {
                        result = num1 / num2;
                        break;
                    }
            }

            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "vui lòng nhập số";
        }
    }
}
