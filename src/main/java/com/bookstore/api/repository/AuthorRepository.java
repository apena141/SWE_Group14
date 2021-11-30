package com.bookstore.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bookstore.api.model.Author;

public interface AuthorRepository extends MongoRepository<Author,Integer> {
}