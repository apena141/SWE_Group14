package com.bookstore.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.api.model.Author;
import com.bookstore.api.repository.AuthorRepository;
import com.bookstore.api.repository.BookRepository;


@RestController
public class AuthorController{
	
	@Autowired
	private AuthorRepository arepository;
	@Autowired
	private BookRepository repository;

	@PostMapping("/addAuthor")
	public String saveAuthor(@RequestBody Author author){
		arepository.save(author);
		return "Added author with id: "+ author.getId();
	}

	@GetMapping("/findAllAuthors")
	public List<Author> getAuthors(){
		return arepository.findAll();
		}

	@DeleteMapping("/deleteauth/{id}")
	public String deleteAuthor(@PathVariable int id){
		arepository.deleteById(id);
		repository.deleteAllByAuthorId(id);
		return"Author and books with author id "+id+" deleted.";
	}
}
