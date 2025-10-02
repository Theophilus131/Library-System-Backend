package com.library.management.system.data.models;


import org.springframework.data.annotation.Id;

@lombok.Data
public class Book {
    @Id

    private String bookId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String categoryName;
    private String ISBN;
    private String status;



}
