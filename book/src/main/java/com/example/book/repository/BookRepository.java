package com.example.book.repository;

import com.example.book.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByGenre(String genre);

    List<Book> findByRatingGreaterThan(double rating);
}
