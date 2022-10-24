package com.example.service.impl;

import com.example.model.User;
import com.example.repository.IUserReposioty;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserReposioty iUserReposioty;

    @Override
    public List<User> findAll() {
        return iUserReposioty.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserReposioty.findAll(pageable);
    }

    @Override
    public void  save(User user) {
         iUserReposioty.save(user);
    }

    @Override
    public void update(User user) {
        iUserReposioty.save(user);
    }

    @Override
    public void remove(int id) {
        iUserReposioty.deleteById(id);
    }
}
