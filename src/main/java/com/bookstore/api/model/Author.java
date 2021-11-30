package com.bookstore.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="Author")
public class Author {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String bio;
	private String publisher;
}
