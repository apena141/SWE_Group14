package com.example.spring.mongo.api.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


@Document(collection = "Wishlist")

public class WishList {
    @Id
    private String id;
    private String wishListName;
    //private String authorName;
}
