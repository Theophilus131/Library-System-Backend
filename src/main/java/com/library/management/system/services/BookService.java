package com.library.management.system.services;

import com.library.management.system.data.models.Book;
import com.library.management.system.dtos.request.BookRequest;
import com.library.management.system.dtos.response.BookResponse;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookResponse addBook(BookRequest bookRequest);
    BookResponse updateBook(BookRequest bookRequest);
    BookResponse deleteBook(BookRequest bookRequest);
    BookResponse getBook(BookRequest bookRequest);
    BookResponse getBookByISBN(BookRequest bookRequest);
    BookResponse getBookByBookName(BookRequest bookRequest);
    BookResponse getBookByAuthorName(BookRequest bookRequest);
    BookResponse getBookByPublisherName(BookRequest bookRequest);


    List<Book> getAllBook();
    Optional<Book> getBookById(String id);
    void deleteBookById(String id);
}
