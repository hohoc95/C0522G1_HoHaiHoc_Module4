package com.example.dto;

import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto  implements Validator {
    private int customerId;

    @NotBlank(message = "Tên khách hàng không được để trống.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên khách hàng không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String customerName;

    @NotBlank(message = "không được để trống.")
    private String customerDayOfBirth;

    private int customerGender;

    @NotBlank(message = "không được để trống.")
    private String customerIdCard;

    @NotBlank(message = "không được để trống.")

    @NotBlank(message = "không được để trống.")
    private String customerPhone;

    @NotBlank(message = "không được để trống.")
    private String customerEmail;

    @NotBlank(message = "không được để trống.")
    private String customerAddress;
    private boolean isDelete;
//    private int isDelete;
    private CustomerType customerType;


    public CustomerDto() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDayOfBirth() {
        return customerDayOfBirth;
    }

    public void setCustomerDayOfBirth(String customerDayOfBirth) {
        this.customerDayOfBirth = customerDayOfBirth;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

//    public int isDelete() {
//        return isDelete;
//    }
//
//    public void setDelete(int delete) {
//        isDelete = delete;
//    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
    }
}
