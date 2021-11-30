package com.bookstore.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.api.model.Book;
import com.bookstore.api.repository.BookRepository;

@RestController
public class BookController{
	
	@Autowired
	private BookRepository repository;

	@PostMapping("/addBook")
	public String makeBook(@RequestBody Book book){
		repository.save(book);
		return "Added book with id: "+ book.getId();
	}
	
	@GetMapping("/findByISBN/{isbn}")
	public Optional<Book> findByISBN(@PathVariable int isbn){
		return repository.findById(isbn);
		}
	
	@GetMapping("/getDetails/{isbn}")
	public String getDetails(@PathVariable int isbn){
		Optional<Book> dbBook = findByISBN(isbn);
		if (dbBook.isPresent()) {
			Book book = dbBook.get();
			String description = book.getDescription();
			String title = book.getBookName();
			return "ISBN: "+isbn+"\nBook: "+title+"\nDescription: "+description;
		}
		else
			return "No Book found with that ISBN, try another ISBN";
		}
	
	@GetMapping("/findByAuthorId/{authorId}")
	public List<Book> authorList(@PathVariable int authorId){
		return repository.findByAuthorId(authorId);
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		return repository.findAll();
	}
	
	@DeleteMapping("/deleteByAuthor/{authorId}")
	public String deleteByAuthor(@PathVariable int authorId){
		repository.deleteAllByAuthorId(authorId);
		return "books with author id "+authorId+" deleted.";
	}

	@DeleteMapping("/delete/{isbn}")
	public String deleteBook(@PathVariable int isbn){
		repository.deleteById(isbn);
		return"book deleted with id: "+isbn;
	}

}
