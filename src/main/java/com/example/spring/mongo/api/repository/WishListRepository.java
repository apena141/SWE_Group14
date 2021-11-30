package com.example.spring.mongo.api.repository;

import com.example.spring.mongo.api.model.WishList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishListRepository extends MongoRepository<WishList, String> {

}
