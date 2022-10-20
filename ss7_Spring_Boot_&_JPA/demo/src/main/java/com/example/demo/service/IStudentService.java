package com.example.demo.service;

//import vn.codegym.model.Student;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    List<Student> findByName(String keyword);
}
