package com.library.management.system.mappers;

import com.library.management.system.data.models.Book;
import com.library.management.system.dtos.request.BookRequest;
import com.library.management.system.dtos.response.BookResponse;


public class BookMapper {

    public static Book toEntity(BookRequest bookRequest){
        Book book = new Book();
        book.setBookName(bookRequest.getBookName());
        book.setAuthorName(bookRequest.getAuthorName());
        book.setPublisherName(bookRequest.getPublisherName());
        book.setCategoryName(bookRequest.getCategoryName());
        book.setISBN(bookRequest.getISBN());
        book.setBookId(bookRequest.getBookId());
        book.setStatus("Available");
        return book;

    }


    public static BookResponse toResponse(Book book){
        BookResponse bookResponse = new BookResponse();

        bookResponse.setBookName(book.getBookName());
        bookResponse.setAuthorName(book.getAuthorName());
        bookResponse.setPublisherName(book.getPublisherName());
        bookResponse.setCategoryName(book.getCategoryName());
        bookResponse.setISBN(book.getISBN());
        bookResponse.setBookId(book.getBookId());
        bookResponse.setStatus(book.getStatus());
        return bookResponse;
    }
}
