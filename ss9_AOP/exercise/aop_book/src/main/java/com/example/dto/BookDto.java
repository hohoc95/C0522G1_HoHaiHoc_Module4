package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookDto implements Validator {
    private int id;
    private String bookTitle;
    private String bookAuthor;
    private int amount;
    private int bookTotal;

    public BookDto() {
    }

    public BookDto(int id, String bookTitle, String bookAuthor, int amount, int bookTotal) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.amount = amount;
        this.bookTotal = bookTotal;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(int bookTotal) {
        this.bookTotal = bookTotal;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDto bookDto = (BookDto) target;
        if("admin".equals(bookDto.getBookTitle())){
            errors.rejectValue("name", "name.forbidden","Không được là admin");
        }
    }
}
