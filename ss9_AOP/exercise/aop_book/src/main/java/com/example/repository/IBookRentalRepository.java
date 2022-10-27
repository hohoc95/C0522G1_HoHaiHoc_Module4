package com.example.repository;

import com.example.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRentalRepository  extends JpaRepository<BookRental, Integer> {
    BookRental findByBookCode(String bookCode);

}
