package com.example.controller;
import com.example.service.ICurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConverterController {
    @Autowired
    private ICurrencyConverterService iCurrencyConverterService;

    @GetMapping("/")
    public String showList(){
        return "converter";
    }

    @GetMapping("/exchange")
    public ModelAndView result(@RequestParam double money){
        return new ModelAndView("converter","result",iCurrencyConverterService.calculate(money));

    }

}
