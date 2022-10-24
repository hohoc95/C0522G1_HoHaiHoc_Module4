package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public ModelAndView showUserList(@PageableDefault(value = 5) Pageable pageable){
        return new ModelAndView("list", "userList", iUserService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        model.addAttribute("user", new User());
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

//    @PostMapping("/save")
//    public String save(User user, RedirectAttributes redirectAttributes) {
//        iUserService.save(user);
//        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
//        return "redirect:/";
//    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new UserDto().validate(userDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);

            iUserService.save(user);
            redirectAttributes.addFlashAttribute("mess", "Add new successful!");
            return "redirect:/";
        }
    }


}
