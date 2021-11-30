package com.example.spring.mongo.api.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.spring.mongo.api.model.Book;

import com.example.spring.mongo.api.repository.BookRepository;


@RestController

public class BookController {
	
	@Autowired
	private BookRepository repository; 
	
	
	@PostMapping("/addBook")
	public void saveBook(@RequestBody Book book) {
		repository.save(book);
		// return "Added book with id : " + book.getId();
	}
	
	@GetMapping("/showAllBooks")
	public List<Book> getBooks(){
		return repository.findAll();

	}

	@GetMapping("/findBook/{id}")
	public Optional<Book> getBook(@PathVariable String id){
		return repository.findById(id);
	}
	
	@PostMapping("/delete/{id}")
	public void deleteBook(@PathVariable String id) {
		repository.deleteById(id);
		//return "book deleted with id:" + id;
	}

}
