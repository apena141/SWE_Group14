package com.impulse.spring.mongo.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "user")
public class User {
    @Id
    private String user;
    private Cart cart;
}
