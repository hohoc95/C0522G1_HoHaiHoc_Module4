package com.example.controller;

import com.example.dto.OrderProductDto;
import com.example.model.OrderProduct;
import com.example.service.IOrderProductService;
import com.example.service.IProductService;
import com.example.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.ManyToOne;

@Controller
@RequestMapping("/")
public class OrderProductController {



    @Autowired
    private IProductService iProductService;

    @Autowired
    private IProductTypeService iProductTypeService;

    @Autowired
    private IOrderProductService iOrderProductService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 1)Pageable pageable, Model model){
        model.addAttribute("orderProductList",iOrderProductService.findbyOrderProduct(pageable));
        model.addAttribute("productTypeList", iProductTypeService.findAll());
        model.addAttribute("productList", iProductService.findAll());
        return "list";
    }

    @GetMapping("edit/{id}")
    public String showEdit (@PathVariable int id, Model model){
        OrderProductDto orderProductDto = new OrderProductDto();
        OrderProduct orderProduct = iOrderProductService.findById(id).get();
        BeanUtils.copyProperties(orderProduct, orderProductDto);
        model.addAttribute("productTypeList", iProductTypeService.findAll());
        model.addAttribute("productList", iProductService.findAll());
        return "edit";
    }
    @PostMapping("update")
    public String updateOrder(@Validated @ModelAttribute OrderProductDto orderProductDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model){
        new OrderProductDto().validate(orderProductDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute(iOrderProductService.findAll());
            return "edit";
        }
        else {
            OrderProduct orderProduct = new OrderProduct();
            BeanUtils.copyProperties(orderProductDto, orderProduct);
            iOrderProductService.save(orderProduct);
            redirectAttributes.addFlashAttribute("mess", "Edit successful!");
            return "redirect:/";
        }
    }

}
