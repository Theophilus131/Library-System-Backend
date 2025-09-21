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

    @Autowired
    private BookRepository bookRepository;

  @Override
  public BookResponse addBook(BookRequest bookRequest) {
      Book book = BookMapper.toEntity(bookRequest);
      bookRepository.save(book);
      return BookMapper.toResponse(book);
  }

  @Override
  public List<BookResponse> getAllBooks(){
      return null;
  }

    @Override
    public Optional<Book> getBookById(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }




}
