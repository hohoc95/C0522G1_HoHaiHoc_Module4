package com.example.controller;

import com.example.dto.FacilityDto;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @ModelAttribute("facilityTypeList")
    public List<FacilityType> facilityTypeList(){
        return iFacilityTypeService.findAll();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> rentTypeList(){
        return iRentTypeService.findAll();
    }


    @GetMapping("")
    public String showListAndSearch(@PageableDefault(value = 5) Pageable pageable,
                                    @RequestParam(value = "name",defaultValue = "") String name,
                                    @RequestParam(value = "facilityType",defaultValue = "") String facilityType,
                                    Model model) {
//        System.out.println(name);
        model.addAttribute("facilityList", iFacilityService.findByFacilityNameContaining(name,facilityType, pageable));
//        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
//        model.addAttribute("rentTypeList",iRentTypeService.findAll());
        model.addAttribute("name", name);


        return "facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
//        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
//        model.addAttribute("rentTypeList",iRentTypeService.findAll());
        model.addAttribute("facilityDto",new FacilityDto());

        return "facility/create";
    }

    @PostMapping("/save")
    public String saveFacility (@Validated @ModelAttribute FacilityDto facilityDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        new FacilityDto().validate(facilityDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
//            model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
//            model.addAttribute("rentTypeList", iRentTypeService.findAll());

            return "facility/create";
        }
        else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("mess","Add new Facility successful!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        FacilityDto facilityDto = new FacilityDto();
        Facility facility = iFacilityService.findById(id);
        BeanUtils.copyProperties(facility, facilityDto);
//        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
//        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("facilityDto", facilityDto);

        return "facility/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute FacilityDto facilityDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
//            model.addAttribute("rentTypeList", iRentTypeService.findAll());

            return "facility/edit";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);

            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("mess", "Edit Facility Successful!");
            return "redirect:/facility";
        }

    }

/*
* Xóa mềm - Soft Delete.
*/

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteId") Integer facilityId, RedirectAttributes redirectAttributes) {
        Facility facility = iFacilityService.findById(facilityId);
        facility.setDelete(true);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Delete successfull!");
        return "redirect:/facility";
    }

/*
 * Xóa cứng
 * */
/*
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteId") Integer facilityId) {
        iFacilityService.remove(facilityId);
        return "redirect:/facility";
    }
*/

}
