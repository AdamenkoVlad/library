package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);

    void deleteById(Long id);



}
