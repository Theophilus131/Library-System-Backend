package com.library.management.system.dtos.response;


@lombok.Data
public class BookResponse {
    private String bookName;
    private String authorName;
    private String publisherName;
    private String categoryName;
    private String ISBN;
    private String bookId;
    private String status;
}
