package com.example.controller;

import com.example.dto.RoomDto;
import com.example.model.Room;
import com.example.service.IRentTypeService;
import com.example.service.IRoomService;
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

import java.util.Optional;

@Controller
@RequestMapping("/")
public class RoomControler {

    @Autowired
    private IRoomService iRoomService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String showListAndSearch(@PageableDefault(value = 5)Pageable pageable,
                                    @RequestParam(value = "id", defaultValue = "") Integer id,
                                    @RequestParam(value = "name", defaultValue = "") String name,
                                    @RequestParam(value = "phone", defaultValue = "") String phone,
                                    Model model){
        model.addAttribute("roomList", iRoomService.findByRoom(id, name, phone, pageable));
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);

        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("roomDto", new RoomDto());
        return "create";
    }

    @PostMapping("save")
    public String saveRoom(@Validated @ModelAttribute RoomDto roomDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model){
        new RoomDto().validate(roomDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("rentTypeList", iRentTypeService.findAll());
            return "create";
        }
        else {
            Room room = new Room();
            BeanUtils.copyProperties(roomDto, room);

            iRoomService.save(room);
            redirectAttributes.addFlashAttribute("mess","Add new room susscessful!");
            return "redirect:/";
        }
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        RoomDto roomDto = new RoomDto();

        Room room = iRoomService.findById(id).get();  // D??ng ???????c

//        Optional<Room> room = iRoomService.findById(id); // Edit bi???n th??nh th??m m???i.

//        Optional<Room> room = iRoomService.findById(Integer.valueOf(id)); // Edit bi???n th??nh create Kh??ng hi???n d??? li???u (d??? li???u ???????c t???o) trong form edit.

        BeanUtils.copyProperties(room, roomDto);
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("roomDto", roomDto);
        return "edit";
    }

    @PostMapping("/update")
    public String updateRoom(@Validated @ModelAttribute RoomDto roomDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        new RoomDto().validate(roomDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute(iRentTypeService.findAll());
            return "edit";
        }
        else {
            Room room = new Room();
            BeanUtils.copyProperties(roomDto, room);

            iRoomService.save(room);
            redirectAttributes.addFlashAttribute("mess", "Edit successful!");
            return "redirect:/";
        }
    }

    /*
        X??a m???m
    */
    @GetMapping("delete/{id}")
    public String remove(@PathVariable(value = "id") Integer id, RedirectAttributes redirectAttributes){
        Room room = iRoomService.findById(id).get();  // D??ng ???????c

        room.setDelete(true);
        iRoomService.save(room);
        redirectAttributes.addFlashAttribute("mess","Delete successful!");
        return "redirect:/";
    }

    /*
        X??a c???ng
    */
/*
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteId") Integer roomId){
        iRoomService.remove(roomId);
        return "redirect:/";
    }
*/

}
