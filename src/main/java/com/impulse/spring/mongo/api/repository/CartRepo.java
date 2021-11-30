package com.impulse.spring.mongo.api.repository;
import com.impulse.spring.mongo.api.model.*;


import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories("com.impulse.spring.mongo.api.repository.CartRepo")
@Repository
public interface CartRepo extends MongoRepository <CartItem,String> {
      public List<Book> findByUser(Optional<User> currentUser);
      //public List<Book> findByUserName(String userName);
//    public CartItem findOne(String productName);
	//public void deleteByProductName(CartItem delete);
}
