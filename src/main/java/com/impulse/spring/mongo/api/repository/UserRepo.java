package com.impulse.spring.mongo.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.impulse.spring.mongo.api.model.Book;
import com.impulse.spring.mongo.api.model.User;

public interface UserRepo extends MongoRepository <User,String> {

	List<Book> findCartByUser(String user);
	
}
