package com.impulse.spring.mongo.api.resource;

import com.impulse.spring.mongo.api.model.Book;
import com.impulse.spring.mongo.api.model.Cart;
import com.impulse.spring.mongo.api.model.User;
import com.impulse.spring.mongo.api.repository.CartRepo;
import com.impulse.spring.mongo.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartControl {
      @Autowired
      private UserRepo userRepo;
      @Autowired
      private CartRepo cartRepo;

    @PostMapping("/addCart/{user}")
    public String saveCart(@PathVariable String user, @RequestBody Book book){
        Cart currCart = userRepo.findCartByUser(user);
        List<Book> books = currCart.getListOfBooks();
        books.add(book);
        cartRepo.save(currCart);
        userRepo.save(userRepo.findByUser(user));
        return "Saved book to cart!";
    }

  @GetMapping("/retrieveCart/{user}")
  public List<Book> getUserCart (@PathVariable String user){
      Cart cart = userRepo.findCartByUser(user);
      return cart.listOfBooks;
  }
}
