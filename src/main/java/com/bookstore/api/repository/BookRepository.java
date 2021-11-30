package com.bookstore.api.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bookstore.api.model.Book;

public interface BookRepository extends MongoRepository<Book,Integer>{
	
	List<Book> findByAuthorId(int authorId);

	void deleteAllByAuthorId(int authorId);

}
