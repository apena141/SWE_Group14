package com.impulse.spring.mongo.api.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@ComponentScan

@Document(collection = "cart")
@Entity
public class Cart {
      public Cart(){
            listOfBooks = new ArrayList<>();
      }
      public List<Book> listOfBooks;
}


