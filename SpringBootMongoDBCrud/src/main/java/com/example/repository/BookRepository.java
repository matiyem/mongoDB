package com.example.repository;

/*
    created by Atiye Mousavi
    Date: 1/14/2023
    Time: 1:00 PM
*/


import com.example.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}