package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.facility.Facility;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
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

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList(){
        return iCustomerTypeService.findAll();
    }


    @GetMapping("")
    public String showCustomerListAndSearch(@PageableDefault(value = 5) Pageable pageable,
                                            @RequestParam(value = "name",defaultValue = "") String name,
                                            @RequestParam(value = "email",defaultValue = "") String email,
                                            @RequestParam(value = "customerType",defaultValue = "") String customerType,
                                            Model model) {
//        System.out.println(name);
        model.addAttribute("customerList", iCustomerService.findByCustomerNameContaining(name, email, customerType, pageable));
//        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerType", customerType);

        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreateCustomer(Model model) {
//        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
//            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "customer/create";
        }
        else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);

            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("mess", "Add new successful!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomerForm(@PathVariable int id, Model model){
        CustomerDto customerDto = new CustomerDto();
        Customer customer = iCustomerService.findById(id);
        BeanUtils.copyProperties(customer, customerDto);
//        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);

            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("mess", "Edit successful!");
            return "redirect:/customer";
        }
    }

    /*
     * X??a m???m - Soft Delete.
     */

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteId") Integer customerId, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findById(customerId);
        customer.setDelete(true);
//        customer.setDelete(1);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Delete successfull!");
        return "redirect:/customer";

    }

}
