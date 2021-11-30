package com.impulse.spring.mongo.api.repository;

import com.impulse.spring.mongo.api.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories("com.impulse.spring.mongo.api.repository.CartRepo")
@Repository
public interface CartRepo extends MongoRepository <Cart,String> {

}
