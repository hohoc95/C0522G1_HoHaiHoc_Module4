package com.calculator.controller;

import com.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String getIndex() {
        return "calculator";
    }

    @PostMapping("/")
    public ModelAndView calculate(@RequestParam String number1, @RequestParam  String number2, @RequestParam String operator) {
        return new ModelAndView("index", "result", iCalculatorService.calculation(number1, number2, operator));
    }
}
