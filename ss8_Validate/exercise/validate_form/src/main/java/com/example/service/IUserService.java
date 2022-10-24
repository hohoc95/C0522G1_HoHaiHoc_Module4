package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    Page<User> findAll(Pageable pageable);
    void save(User user);
    void update(User user);
    void remove(int id);
}
