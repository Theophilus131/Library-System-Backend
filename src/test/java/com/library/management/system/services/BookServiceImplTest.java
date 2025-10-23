package com.library.management.system.services;

import com.library.management.system.data.models.Book;
import com.library.management.system.data.repositories.BookRepository;
import com.library.management.system.dtos.request.BookRequest;
import com.library.management.system.dtos.response.BookResponse;
import com.library.management.system.mappers.BookMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book sampleBook;
    private BookRequest sampleBookRequest;
    private BookResponse sampleBookResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleBook = new Book();
        sampleBook.setBookId("1");
        sampleBook.setBookName("afro beat");

        sampleBookRequest = new BookRequest();
        sampleBookRequest.setBookId("1");
        sampleBookRequest.setBookName("afro beat");

        sampleBookResponse = new BookResponse();
        sampleBookResponse.setBookId("1");
        sampleBookResponse.setBookName("afro beat");
    }

    @Test
    void getBookById_whenBookFound_shouldReturnBook() {
        when(bookRepository.findById("1")).thenReturn(java.util.Optional.of(sampleBook));
        try(MockedStatic<BookMapper> mapperMock = mockStatic(BookMapper.class)){
            mapperMock.when(() ->BookMapper.toResponse(sampleBook)).thenReturn(sampleBookResponse);

            BookResponse response = bookService.getBookById("1");
            assertEquals(sampleBookResponse,response);


        }
    }

    @Test
    void getBookById_whenBookNotFound_shouldThrowException() {
        when(bookRepository.findById("1")).thenReturn(java.util.Optional.empty());
        assertThrows(RuntimeException.class, () -> bookService.getBookById("1"));

    }

    @Test
    void addBook_whenBookAdded_shouldReturnBook() {
        try(MockedStatic<BookMapper> mapperMock = mockStatic(BookMapper.class)){
            mapperMock.when(() ->BookMapper.toEntity(sampleBookRequest)).thenReturn(sampleBook);
            mapperMock.when(() ->BookMapper.toResponse(sampleBook)).thenReturn(sampleBookResponse);

            BookResponse response = bookService.addBook(sampleBookRequest);

            assertEquals(sampleBookResponse,response);
            Mockito.verify(bookRepository).save(sampleBook);

        }
    }

    @Test
    void updateBook_whenBookUpdated_shouldReturnBook() {
        when(bookRepository.findById("1")).thenReturn(java.util.Optional.of(sampleBook));
        try(MockedStatic<BookMapper> mapperMock = mockStatic(BookMapper.class)){
            mapperMock.when(() ->BookMapper.toEntity(sampleBookRequest)).thenReturn(sampleBook);
            mapperMock.when(() ->BookMapper.toResponse(sampleBook)).thenReturn(sampleBookResponse);

            BookResponse response = bookService.updateBook(sampleBookRequest);
            assertEquals(sampleBookResponse,response);
            Mockito.verify(bookRepository).save(sampleBook);
        }
    }

    @Test
    void updateBook_whenBookNotFound_shouldThrowException() {
        when(bookRepository.findById("1")).thenReturn(java.util.Optional.empty());
        assertThrows(RuntimeException.class, () -> bookService.updateBook(sampleBookRequest));
        Mockito.verify(bookRepository,Mockito.never()).save(sampleBook);
    }


    @Test
    void getAllBooks_whenBooksFound_shouldReturnBooks() {
        when(bookRepository.findAll()).thenReturn(java.util.List.of(sampleBook));
        try(MockedStatic<BookMapper> mapperMock = mockStatic(BookMapper.class)){
            mapperMock.when(() ->BookMapper.toResponse(sampleBook)).thenReturn(sampleBookResponse);
        }
    }

    @Test
    void getAllBooks_whenBooksNotFound_shouldThrowException() {
        when(bookRepository.findAll()).thenReturn(java.util.List.of());
        assertThrows(RuntimeException.class, () -> bookService.getAllBooks());
        Mockito.verify(bookRepository,Mockito.never()).save(sampleBook);
    }

    @Test
    void deleteBookById_whenBookFound_shouldDeleteBook() {
        when(bookRepository.findById("1")).thenReturn(java.util.Optional.of(sampleBook));
        bookService.deleteBookById("1");
        Mockito.verify(bookRepository).deleteById("1");
    }

    @Test
    void deleteBookById_whenBookNotFound_shouldThrowException() {
        when(bookRepository.findById("1")).thenReturn(java.util.Optional.empty());
        assertThrows(RuntimeException.class, () -> bookService.deleteBookById("1"));


    }
}