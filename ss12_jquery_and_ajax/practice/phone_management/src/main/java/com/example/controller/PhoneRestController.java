package com.example.controller;

import com.example.dto.PhoneDto;
import com.example.model.Phone;
import com.example.service.IPhoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/phone/v1")
public class PhoneRestController {
    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getPhoneList(){
        List<Phone> phoneList = iPhoneService.findAll();

        if (phoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phoneList,HttpStatus.OK);
    }
//    @PostMapping
//    private ResponseEntity<Phone> postCreatePhone(@RequestBody Phone phone){
//        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<Phone> save(@RequestBody PhoneDto phoneDto) {
        Phone phone = new Phone();
        BeanUtils.copyProperties(phoneDto, phone);
        iPhoneService.save(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
