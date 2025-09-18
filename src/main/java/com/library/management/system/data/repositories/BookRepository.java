package com.library.management.system.data.repositories;

import com.library.management.system.data.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String>{
    Book findByBookId(String bookId);
}
