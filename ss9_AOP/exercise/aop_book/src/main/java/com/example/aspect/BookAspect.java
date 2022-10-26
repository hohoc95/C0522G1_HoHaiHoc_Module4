package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BookAspect {
    @After("execution(* com.example.controller.BookController.*(..))")
    public void logAfterMethodStudentController(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println("Người nào đó đã truy cập " + nameMethod + " vào lúc: " + LocalDateTime.now());
    }
}
