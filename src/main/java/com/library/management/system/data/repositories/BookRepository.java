package com.library.management.system.data.repositories;

import com.library.management.system.data.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{

    Optional<Book> findById(String id);
}
