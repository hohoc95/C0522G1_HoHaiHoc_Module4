package com.demo.controller;


import com.demo.model.Student;
import com.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Qualifier("StudentService")
    @Autowired
    private IStudentService iStudentService;

    @RequestMapping(value = "/student", consumes = "application/json", produces = "application/json")

    public String showList(Model model, ModelMap modelMap){
        List<Student> studentList = iStudentService.findAll();

        modelMap.addAttribute("studentList",studentList);

        return "list";
    }

    @GetMapping("/list")
    public ModelAndView showList(){
        return new ModelAndView("list","studentList",iStudentService.findAll());
    }

    @GetMapping("/search")
    public ModelAndView showListSearch(@RequestParam(value = "kg", required = false, defaultValue = "") String kq){
        return new ModelAndView("list","studentList", iStudentService.findByName(kq));
    }

    @GetMapping("/detail/{id:[1-3]}}")
    public String showDetail(@PathVariable(value = "id") Integer studentId, Model model){
        System.out.println("Lấy thông tin sinh viên" + studentId);
        model.addAttribute("studentId", studentId);
        return "detail";
    }
}
