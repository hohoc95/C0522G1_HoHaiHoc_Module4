package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CurrencyConverterController {

    @GetMapping("/")
    public String showList(){
        return "/converter";
    }

    @GetMapping("/exchange")
    public String result(@RequestParam double money, Model model){
        Double result = money*23000;
        model.addAttribute("result" , result);
        return "/converter";
    }

}
