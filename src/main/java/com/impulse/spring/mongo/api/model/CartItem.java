package com.impulse.spring.mongo.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ComponentScan

// model begins
@Document(collection = "cart2")
@Entity
public class CartItem {
	@Id
	public String userName;
	public String author;
	public String id;
	public String productName;
	
    //constructor for single cart item
    public CartItem (String id, String author, String productName){
        this.author = author;
        this.productName = productName;
        this.id = id;
    }
}
