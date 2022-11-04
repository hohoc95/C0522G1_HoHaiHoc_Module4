package com.create_blog.config;

import com.create_blog.service.impl.MyUserDetailSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailSevice userDetailSevice;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Cách lấy thông tin UserDetail và cơ chế mã hóa pass
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailSevice)
                .passwordEncoder(passwordEncoder());;
    }
    // Cấu hình xác thực Http Basic và cơ chế phân quyền

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .formLogin()
//                .defaultSuccessUrl("/blog").permitAll()
//                .and().authorizeRequests().anyRequest().authenticated();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/blog").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/create").hasAnyRole("ADMIN")
                .anyRequest().authenticated();
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(persistenceTokenRepository())
                .tokenValiditySeconds(1*24*60*60);
    }
    @Bean
    public PersistentTokenRepository persistenceTokenRepository(){
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }
}
