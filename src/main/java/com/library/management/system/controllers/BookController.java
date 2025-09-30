package com.library.management.system.controllers;


import com.library.management.system.dtos.request.BookRequest;
import com.library.management.system.dtos.response.BookResponse;
import com.library.management.system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @PostMapping
    public BookResponse addBook(@RequestBody BookRequest bookRequest ){
        return bookService.addBook(bookRequest);

    }

    @PostMapping("/update")
    public BookResponse updateBook(@RequestBody BookRequest bookRequest){
        return bookService.updateBook(bookRequest);
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable String id){
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
    }


}
