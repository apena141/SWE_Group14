package com.example.book;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.bson.Document;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import static com.mongodb.client.model.Filters.eq;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class BookApplication {

	public static MongoClient client;
	public static MongoDatabase db;
	public static MongoCollection bookCollection;
	
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);

		// Replace the uri string with your MongoDB deployment's connection string
		String uri = "mongodb+srv://ant:ant123@cluster0.t9sp9.mongodb.net/test";

		try (MongoClient mongoClient = MongoClients.create(uri)) {
			client = mongoClient;
			MongoDatabase database = mongoClient.getDatabase("bookapp");
			MongoCollection<Document> collection = database.getCollection("books");
			Document doc = collection.find(eq("title", "Test Book I wrote")).first();
			System.out.println("Book found:" + doc.toJson());
		}
	}
}
