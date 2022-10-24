package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto  implements Validator {
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên có độ dài tối thiểu 5 ký tự, tối đa 45 ký tự")
    private String firstName;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên có độ dài tối thiểu 5 ký tự, tối đa 45 ký tự")
    private String lastName;

//    @NotBlank(message = "Tuổi không được để trống.")
    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18.")
    private int userAge;

//    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email phải đúng định dạng.")
    private String userEmail;

//    @NotBlank(message = "SĐT không được để trống.")
    @Pattern(regexp = "^0\\d{9}$", message = "SĐT phải có 10 số và số đầu tiên là phải số 0.")
    private String phoneNumber;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("admin".equals(userDto.getFirstName())){
            errors.rejectValue("name", "name.forbidden", "Khong duoc la admin.");
        }
    }
}
