package com.example.dto;

import com.example.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderProductDto implements Validator {

    private Integer orderId;
    private String dateOfBuy;
    private String orderAmount;
    private Product product;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderProductDto orderProductDto = (OrderProductDto) target;
    }
}
