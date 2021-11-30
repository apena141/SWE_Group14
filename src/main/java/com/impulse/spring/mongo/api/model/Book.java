package com.impulse.spring.mongo.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String genre;
    private String productName;
    private int amountSold;
    private double rating;
}