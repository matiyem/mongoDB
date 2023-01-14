package com.example.entity;

/*
    created by Atiye Mousavi
    Date: 1/14/2023
    Time: 12:59 PM
*/


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document              // Maps Entity class objects to JSON formatted Documents
public class Book {

    @Id                 // making this variable as ID, will be auto-generated by MongoDB
    private String id;

    @NonNull
    private Integer bookId;
    @NonNull
    private String bookName;
    @NonNull
    private String bookAuthor;
    @NonNull
    private Double bookCost;
}