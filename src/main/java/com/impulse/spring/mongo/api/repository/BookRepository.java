package com.impulse.spring.mongo.api.repository;

import com.impulse.spring.mongo.api.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findByRatingGreaterThan(double rating);
	Book findByProductName(String bookName);
}
