package com.example.entity;

/*
    created by Atiye Mousavi
    Date: 1/14/2023
    Time: 2:20 PM
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Books")
public class Book {

    @Id
    private Integer id;

    private String name;
    private Integer pages;
    private String author;
    private Double cost;
}