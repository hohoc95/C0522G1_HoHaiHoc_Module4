package com.sandwich.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class SandwichController {
    @GetMapping("/")
    public String showList() {
        return "spice";
    }

    @GetMapping("/save")
    public ModelAndView result(@RequestParam(value = "condiment", defaultValue = "") String[] arr) {
        ModelAndView modelAndView = new ModelAndView("spice");
        
        if (arr.length == 0) {
            modelAndView.addObject("condiment", "You not choose!");
        } else {
            modelAndView.addObject("condiment", arr);
        }

        return modelAndView;
    }
}
