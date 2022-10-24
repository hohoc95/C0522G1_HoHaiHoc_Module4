package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserReposioty extends JpaRepository<User, Integer> {
    User findById(int id);
}
