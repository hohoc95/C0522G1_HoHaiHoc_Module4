package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/")
    public String showBlogList(@PageableDefault(value = 2) Pageable pageable,
                               @RequestParam(defaultValue = "") String name,
                               Model model) {
        System.out.println(name);
        model.addAttribute("blogList", iBlogService.findByNameContaining(name, pageable));
        model.addAttribute("name", name);
        return "/blog";
    }

//    @GetMapping("/")
//    public ModelAndView showBlogList(@PageableDefault(value = 5) Pageable pageable, @RequestParam(required = false) String nameSearch) {
//        Page<Blog> pages = iBlogService.findAll(pageable);
//        return new ModelAndView("blog", "blogList", pages);
//    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogDto", new BlogDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/";
    }
//    @PostMapping("/save")
//    public String save(@Validated @ModelAttribute BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        new BlogDto().validate(blogDto, bindingResult);
//        if(bindingResult.hasFieldErrors()){
//            model.
//        }

//        iBlogService.save(blog);
//        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
//        return "redirect:/";
//    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "update successful");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess", "delete successful");
        return "redirect:/";
    }

}
