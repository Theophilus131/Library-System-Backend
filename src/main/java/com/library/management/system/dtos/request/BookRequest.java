package com.library.management.system.dtos.request;


@lombok.Data
public class BookRequest {
    private String bookName;
    private String authorName;
    private String publisherName;
    private String categoryName;
    private String ISBN;
    private String bookId;

}
