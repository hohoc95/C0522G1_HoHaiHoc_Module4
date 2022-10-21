package com.create_blog.controller;

import com.create_blog.model.Blog;
import com.create_blog.service.IBlogService;
import com.create_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping("")
//    public ModelAndView showBlogList() {
//        return new ModelAndView("blog", "blogList", iBlogService.findAll());
//    }
    @GetMapping("")
    public ModelAndView showBlogList(@PageableDefault (value = 5) Pageable pageable) {
        return new ModelAndView("blog", "blogList", iBlogService.findAll(pageable));
    }

    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("categoryList",iCategoryService.findAll());

        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/";
    }

}
