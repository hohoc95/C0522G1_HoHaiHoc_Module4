package com.example.controller;

import com.example.dto.ContractDto;
import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.facility.IFacilityService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerServicel;

    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute
    public List<AttachFacility> attachFacilityList() {
        return iAttachFacilityService.findAll();
    }

    public List<ContractDetail> contractDetailList() {
        return iContractDetailService.findAll();
    }

    public List<Customer> customerList() {
        return iCustomerServicel.findAll();
    }

    public List<Facility> facilityList() {
        return iFacilityService.findAll();
    }


    @GetMapping("")
    public String showList(@PageableDefault(value = 10) Pageable pageable, Model model) {
        model.addAttribute("contractList", iContractService.findByContract(pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("contractDetailList", iContractDetailService.findAll());
        model.addAttribute("customerList", iCustomerServicel.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
//        model.addAttribute("contract", new Contract());
//        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customerList", iCustomerServicel.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        return "contract/create";
    }

    @PostMapping("/save")
    public String saveContract(@Validated @ModelAttribute ContractDto contractDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        new ContractDto().validate(contractDto, bindingResult);

//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("customerList", iCustomerServicel.findAll());
//            model.addAttribute("facilityList", iFacilityService.findAll());
//            return "contract/create";
//
//        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);

            model.addAttribute("customerList", iCustomerServicel.findAll());
            model.addAttribute("facilityList", iFacilityService.findAll());

            iContractService.save(contract);

            redirectAttributes.addFlashAttribute("mess", "Add new successful!");
            return "redirect:/contract";
        }

    @GetMapping("/view/{id}")
    public String showViewForm(@PathVariable int id, Model model){
        model.addAttribute("contract", iContractService.findById(id));
        return "/view";
    }


/*    @GetMapping("/view/{id}")
    public String showViewForm(@PathVariable int id, Model model){
        model.addAttribute("book", iBookService.findById(id));
        return "/view";
    }*/

//    @GetMapping("")

}
