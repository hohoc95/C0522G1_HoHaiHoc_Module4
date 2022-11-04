package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
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

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showCustomerListAndSearch(@PageableDefault(value = 5) Pageable pageable,
                                            @RequestParam(defaultValue = "") String name,
                                            String email,
                                            Model model) {
        System.out.println(name);
        model.addAttribute("customerList", iCustomerService.findByCustomerNameContaining(name, pageable));
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("name", name);

        return "customer/list";
    }


    @GetMapping("/create")
    public String showFormCreateCustomer(Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
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
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
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
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
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
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
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
* Xóa mềm - Soft Delete.
*/

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable(value = "id") Integer id, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findById(id);
        customer.setDelete(true);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Delete successfull!");
        return "redirect:/customer";
    }

/*
* Xóa cứng
* */

//    @GetMapping("/delete/{id}")
//    public String showDeleteFormCustomer(@PathVariable int id, Model model){
//        model.addAttribute("customerList",iCustomerService.findById(id));
//        model.addAttribute("customerDto", new CustomerDto());
//        return "customer/delete";
//    }

//    @PostMapping("/delete")
//    public String deleteCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
//        iCustomerService.remove(customer.getCustomerId());
//        redirectAttributes.addFlashAttribute("mess","Delete successful!");
//        return "redirect:/customer";
//    }

//    @GetMapping("/delete/{id}")
//    public String delete(@RequestParam(value = "idDelete") int id, RedirectAttributes redirect) {
//        iCustomerService.delete(id);
//        redirect.addFlashAttribute("mess", "Removed Customer successfully!");
//        return "redirect:/customer";
//    }



/*
Xóa mềm - Soft Delete.
*/

//    @GetMapping("/delete/{id}")
//    public String showDeleteFormCustomer(@PathVariable int id, Model model){
//        CustomerDto customerDto = new CustomerDto();
//        model.addAttribute("customerList", iCustomerService.delete(id)) ;
//        BeanUtils.copyProperties(customer, customerDto);
//        model.addAttribute("customerDto", customerDto);


//        BeanUtils.copyProperties(customer, customerDto);
//        model.addAttribute("customerList", (customer.isDelete()== false) );
//        model.addAttribute("customerDto", customerDto);
//        return "redirect:/customer";
//    }
//    @PostMapping("/delete")
//    public String deleteCustomer(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes,
//                                 Model model){
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDto, customer);
//
//        iCustomerService.save(customer);
//        redirectAttributes.addFlashAttribute("mess", "Delete successful!");
//        return "redirect:/customer";
//    }
}
