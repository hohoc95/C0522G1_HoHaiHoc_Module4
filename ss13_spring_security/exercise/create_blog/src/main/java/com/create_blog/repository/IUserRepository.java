package com.create_blog.repository;

import com.create_blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
    User findById(int id);
}
