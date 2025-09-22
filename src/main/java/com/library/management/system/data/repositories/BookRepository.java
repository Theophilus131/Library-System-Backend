package com.library.management.system.data.repositories;

import com.library.management.system.data.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{

   List<Book> findByStatus(String status);
    List<Book> findByCategoryName(String categoryName);
}
