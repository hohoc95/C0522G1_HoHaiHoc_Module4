package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("")
    public String save(Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","Successfully added new");
        return "redirect:/";
    }


//    @GetMapping("")
//    public String edit(Model model){
//        productService.edit
//    }

//    @GetMapping("")
//    public String update(Model model){
//        model.addAttribute("")
//    }


}
