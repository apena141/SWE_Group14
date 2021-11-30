package com.example.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.mongo.api.model.Book;


public interface BookRepository extends MongoRepository<Book, String> {

}

