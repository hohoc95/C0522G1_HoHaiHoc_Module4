package com.sandwich.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class SandwichController {
    @GetMapping("/")
    public String showList() {
        return "spice";
    }

    @RequestMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment", defaultValue = "") String[] arr) {
        if (arr.length == 0) {
            return new ModelAndView("spice", "condiment", "You have not chosen!");
        } else {
            return new ModelAndView("spice", "condiment", arr);
        }
    }
}
