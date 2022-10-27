package com.example.service;

import com.example.model.BookRental;

public interface IBookRentalService {
    void save(BookRental bookRental);

    BookRental findByBookCode(String bookCode);

    void remove(Integer id);
}
