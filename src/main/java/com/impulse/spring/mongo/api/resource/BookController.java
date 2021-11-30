package com.impulse.spring.mongo.api.resource;

import com.impulse.spring.mongo.api.model.*;
import com.impulse.spring.mongo.api.repository.*;
import com.mongodb.client.model.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "Added book with id: " ;
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return repository.findAll();
    }

    @GetMapping("/findBook/{id}")
    public Optional<Book> getBook(@PathVariable String id){
        return repository.findById(id);
    }

    @GetMapping("findBookByGenre/{genre}")
    public List<Book> getBookByGenre(@PathVariable String genre) {
        return repository.findByGenre(genre);
    }

    @GetMapping("findBookByRating/{rating}")
    public List<Book> getBookByRating(@PathVariable double rating) {
        return repository.findByRatingGreaterThan(rating);
    }

    @GetMapping("findBookByTopSellers")
    public List<Book> getBookByAmountSold() {
        return repository.findAll(Sort.by("amountSold").descending()).subList(0, 10);
    }

    @GetMapping("findBooksByLimit/{limit}")
    public List<Book> getBooksByLimit(@PathVariable int limit) {
        return repository.findAll().subList(0, limit);
    }
}