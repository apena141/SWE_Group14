package com.bookstore.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="Book")
public class Book{
	
	@Id
	private int id;
	private String bookName;
	private String description;
	private float price;
	private String authorName;
	private String genre;
	private String publisher;
	private String yearPub;
	private int sold;
	private int authorId;

}
