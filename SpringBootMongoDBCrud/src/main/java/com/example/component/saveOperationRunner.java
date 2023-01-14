package com.example.component;

/*
    created by Atiye Mousavi
    Date: 1/14/2023
    Time: 1:44 PM
*/


import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class saveOperationRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public void run(String... args) throws Exception {

        // saveAll() operation : saveAll() inserts more than one records at a time

        bookRepo.saveAll(Arrays.asList(
                new Book(501, "Core Java", "Kathy Sierra", 1065.5),
                new Book(502, "Spring in Action", "Craig Walls", 940.75),
                new Book(503, "Hibernate in Action", "Gavin King", 889.25),
                new Book(504, "Practical MongoDB", "Shakuntala Gupta", 785.0)
        ));

        // save() operation : Updating ID(PK) manually (allowed) : It will create one new record

        Book book = bookRepo.save(new Book("ISBN10:1484240251", 504,"Practical MongoDB", "Shakuntala Gupta", 785.0));  // insert

        // save() operation : save() also updates record based on the PK

        bookRepo.save(new Book("ISBN10:1484240251", 505,"Practical MongoDB", "Shakuntala Gupta", 728.0));  // update
        bookRepo.save(new Book(book.getId(), 505,"Practical MongoDB", "Navin Sabharwal", 798.0));  // update

        // insert() operation : This method will also insert one new record

        bookRepo.insert(new Book(506,"Java Design Patterns", "Kathy Sierra", 924.0)); // insert

        System.out.println("All Data saved into MongoDB");

        Optional<Book> opt= bookRepo.findById("ISBN10:1484240251");
        if(opt.isPresent()) {
            Book b1 = opt.get();
            System.out.println("Here is the book details : " +b1);
        } else {
            System.out.println("Given Id not found");
        }

        bookRepo.deleteById("ISBN10:1484240251");    // Delete Book of a particular Id

        bookRepo.deleteAll();


    }
}