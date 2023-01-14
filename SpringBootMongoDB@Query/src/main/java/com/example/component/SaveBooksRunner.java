package com.example.component;

/*
    created by Atiye Mousavi
    Date: 1/14/2023
    Time: 2:23 PM
*/

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SaveBooksRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public void run(String... args) throws Exception {

        bookRepo.saveAll(List.of(
                new Book(500, "Core Java", 200, "Kathy Sierra", 1065.5),
                new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0),
                new Book(502, "Spring in Action", 480, "Craig Walls", 940.75),
                new Book(503, "Pro Angular", 260, "Freeman", 1949.25),
                new Book(504, "HTML CSS", 100, "Thomas Powell", 2317.09),
                new Book(505, "Hibernate in Action", 180, "Gavin King", 889.25),
                new Book(506, "Practical MongoDB", 180, "Shakuntala Gupta", 785.0),
                new Book(507, "Pro Spring Boot", 850, "Felipe Gutierrez", 2167.99),
                new Book(508, "Beginning jQuery", 180, "Franklin", 1500.00),
                new Book(509, "Java Design Patterns", 114, "Devendra Singh", 919.99)

        ));

        System.out.println("------All records has been saved successfully-------");

        //region getBookById()
        Optional<Book> opt = bookRepo.getBookById(504);
        if(opt.isPresent()) {
            System.out.println(opt.get());
        }
        else {
            System.out.println("DATA NOT FOUND");
        }
        //endregion


        //region getBooksByAuthor()
        bookRepo.getBooksByAuthor("Kathy Sierra").forEach(System.out::println);
        //endregion


        //region getBooksByPages()
        bookRepo.getBooksByPages(400).forEach(System.out::println);
        //endregion


        //region getBooksByAuthorAndCost()
        bookRepo.getBooksByAuthorAndCost("Freeman",1949.25).forEach(System.out::println);
        //endregion

        //region getBooksByAuthorOrName()
        bookRepo.getBooksByAuthorOrName("Kathy Sierra"," ").forEach(System.out::println);

        bookRepo.getBooksByAuthorOrName("Freeman","Spring in Action").forEach(System.out::println);
        //endregion

        //region getBooksCountByAuthor()
        Integer count = bookRepo.getBooksCountByAuthor("Kathy Sierra"); System.out.println(count);
        //endregion

        //region getBooksByAuthorSortByName()
        bookRepo.getBooksByAuthorSortByName("Kathy Sierra").forEach(System.out::println);
        //endregion


        //region getBookNameAndAuthorByPages()
        bookRepo.getBookNameAndAuthorByPages(180).forEach(System.out::println);
        //endregion

        //region getAllBooksByAuthor()
        bookRepo.getAllBooksByAuthor("Kathy Sierra").forEach(System.out::println);
        //endregion

        //region getAllBooksByAuthor()
        bookRepo.getBooksByAuthorRegEx("^S").forEach(System.out::println);
        //endregion





    }
}