package com.create_blog.service.impl;

import com.create_blog.model.MyUserDetail;
import com.create_blog.model.User;
import com.create_blog.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyUserDetailSevice implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = iUserRepository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User name" + username + "not found");
        }
        return new MyUserDetail(user);
    }
}
