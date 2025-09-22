package com.library.management.system.services;

import com.library.management.system.data.models.Book;
import com.library.management.system.data.repositories.BookRepository;
import com.library.management.system.dtos.request.BookRequest;
import com.library.management.system.dtos.response.BookResponse;
import com.library.management.system.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

   private final BookRepository bookRepository;

   @Autowired
   public BookServiceImpl(BookRepository bookRepository){
       this.bookRepository = bookRepository;
   }

   @Override
    public BookResponse getBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return BookMapper.toResponse(book.get());
        }
        throw new RuntimeException("Book not found");
    }

    @Override
    public BookResponse addBook(BookRequest bookRequest) {
        Book book = BookMapper.toEntity(bookRequest);
        bookRepository.save(book);
        return BookMapper.toResponse(book);
    }

    @Override
    public BookResponse updateBook(BookRequest bookRequest) {
        Optional<Book> book = bookRepository.findById(bookRequest.getBookId());
        if(book.isPresent()){
            Book updatedBook = BookMapper.toEntity(bookRequest);
            bookRepository.save(updatedBook);
            return BookMapper.toResponse(updatedBook);
        }
        throw new RuntimeException("Book not found");
    }

    @Override
    public List<BookResponse> getAllBooks(){
       return null;

    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }




}
