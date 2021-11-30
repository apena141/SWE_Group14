package com.example.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.mongo.api.repository.WishListRepository;
import com.example.spring.mongo.api.model.WishList;

@RestController

public class WishController {

    @Autowired
    private WishListRepository repository;


    @PostMapping("/addWishList")
    public void saveList(@RequestBody WishList wishList) {
        repository.save(wishList);
        // return "Added book with id : " + book.getId();
    }

    @GetMapping("/showAllLists")
    public List<WishList> getList(){
        return repository.findAll();

    }

    @GetMapping("/findList/{id}")
    public Optional<WishList> getList(@PathVariable String id){
        return repository.findById(id);
    }

  

}
