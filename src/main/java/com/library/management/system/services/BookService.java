package com.library.management.system.services;

import com.library.management.system.data.models.Book;
import com.library.management.system.dtos.request.BookRequest;
import com.library.management.system.dtos.response.BookResponse;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookResponse getBookById(String id);
    BookResponse addBook(BookRequest bookRequest);
    BookResponse updateBook(BookRequest bookRequest);
    List<BookResponse> getAllBooks();
    void deleteBookById(String id);
}
