package com.example.controller;

import com.example.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public LoginDto setUpLoginForm(){
        return new LoginDto();
    }

//    @RequestParam("/login")
//    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model){
//        Cookie cookie = new Cookie("setUser", setUser);
//        model.addAttribute("cookieValue", cookie);
//        return "/login";
//    }
}
