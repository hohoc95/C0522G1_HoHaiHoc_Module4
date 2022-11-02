package com.create_blog.service;

import com.create_blog.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(int id);
}
