package com.create_blog.service.impl;

import com.create_blog.model.User;
import com.create_blog.repository.IUserRepository;
import com.create_blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return iUserRepository.findById(id);
    }
}
