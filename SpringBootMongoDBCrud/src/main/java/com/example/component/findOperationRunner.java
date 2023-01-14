package com.example.component;

/*
    created by Atiye Mousavi
    Date: 1/14/2023
    Time: 1:45 PM
*/


import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class findOperationRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public void run(String... args) throws Exception {

        // findAll() : It will retireve all records saved into DB
        List<Book> bookList = bookRepo.findAll();
        bookList.forEach(System.out::println);     // Printing all saved books
    }
}
