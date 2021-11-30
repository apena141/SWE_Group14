package com.impulse.spring.mongo.api.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// import org.springframework.http.HttpStatus;

import java.net.URL;

@Getter
@Setter
@ToString
@ComponentScan

@Document(collection = "cart")
@Entity
public class CartItem {

      @Id
      public User user;
      public List<Book> listOfBooks;
//    public String author;
//    public Book newItem;
//    public String id; 
//    public String productName;
//    public int numBooks;

    // public CartItem(){
        
    // }
    
    // constructor for single cart item
//    public CartItem (String id, String author, String productName)  {
//        //numBooks = listOfBooks.size();
//        //this.userName = userName;
//        this.author = author;
//        this.productName = productName;
//        this.id = id;
//        
//    }
}


