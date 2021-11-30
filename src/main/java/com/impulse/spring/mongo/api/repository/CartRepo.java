package com.impulse.spring.mongo.api.repository;
import com.impulse.spring.mongo.api.model.*;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories("com.impulse.spring.mongo.api.repository.CartRepo")
@Repository
public interface CartRepo extends MongoRepository <CartItem,String> {
    public List<CartItem> findByUserName(String userName);
	public CartItem findByProductName(String productName);
	public List<CartItem> save(List<CartItem> cart);
}
