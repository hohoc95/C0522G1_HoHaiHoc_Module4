package com.example.controller;

import com.example.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false)CartDto cart){

//        Có thể dùng @ModelAtribute như @SessionAttribute, nhưng @SessionAttibute có thể dùng xuyên Controller.
//        public ModelAndView showCart(@ModelAttribute(value = "cart", required = false)CartDto cart)

        return new ModelAndView("cart/listCart", "cart",cart);
        }
}