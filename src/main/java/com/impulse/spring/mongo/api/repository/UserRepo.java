package com.impulse.spring.mongo.api.repository;

import com.impulse.spring.mongo.api.model.Cart;
import com.impulse.spring.mongo.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository <User,String> {
	Cart findCartByUser(String user);

	User findByUser(String user);
}
