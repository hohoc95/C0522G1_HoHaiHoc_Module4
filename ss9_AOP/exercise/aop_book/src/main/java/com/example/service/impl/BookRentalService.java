package com.example.service.impl;

import com.example.model.BookRental;
import com.example.repository.IBookRentalRepository;
import com.example.service.IBookRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRentalService implements IBookRentalService {
    @Autowired
    private IBookRentalRepository iBookRentalRepository;
    @Override
    public void save(BookRental bookRental) {
        iBookRentalRepository.save(bookRental);
    }

    @Override
    public BookRental findByBookCode(String bookCode) {
        return iBookRentalRepository.findByBookCode(bookCode);
    }

    @Override
    public void remove(Integer id) {
        iBookRentalRepository.deleteById(id);
    }
}
