package com.demo.repository;

import com.demo.model.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
