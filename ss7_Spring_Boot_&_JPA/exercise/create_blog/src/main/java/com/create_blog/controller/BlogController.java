package com.create_blog.controller;

import com.create_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ModelAndView showBlogList() {
        return new ModelAndView("blog", "blogList", iBlogService.findAll());
    }


}
