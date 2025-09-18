package com.library.management.system.data.models;


import org.springframework.data.annotation.Id;

@lombok.Data
public class Book {
    @Id

    private String BookId;
    private String BookName;
    private String AuthorName;
    private String PublisherName;
    private String CategoryName;
    private String ISBN;


}
