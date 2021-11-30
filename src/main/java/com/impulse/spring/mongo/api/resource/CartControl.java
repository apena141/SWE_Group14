package com.impulse.spring.mongo.api.resource;
import java.util.List;
import java.util.Optional;

import com.impulse.spring.mongo.api.model.Book;
import com.impulse.spring.mongo.api.model.CartItem;
import com.impulse.spring.mongo.api.model.User;
import com.impulse.spring.mongo.api.repository.*;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.util.UriComponentsBuilder;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Component
@RestController
//@RequestMapping("/shopping_cart/cart")
public class CartControl {

  @Autowired
  private CartRepo cartRepo;
  private BookRepository bookRepo;
  private UserRepo userRepo;
  
//  CartControl (CartRepo cartRepo){
//	  cartRepo = cartRepo;
//  }

  //@RequestMapping (value = "/makeCart/{userName}", method = RequestMethod.POST)
//  @PostMapping("/makeCart/{userName}")
//  public String createCart (@PathVariable("userName") String userName) {
//	  Optional<User> currentUser = userRepo.findById(userName);
//	  currentUser.
//      List<Book> cart = cartRepo.findByUser(currentUser);
//      
//      if (cart == null) {
//    	  return "Cart Empty";
//      }
//     
//      cartRepo.insert(cart);
//      return "Cart for \"" + userName + "\" created";
//  }

  //@RequestMapping (value = "/retrieveCart/{userName}", method = RequestMethod.GET)
  @GetMapping("/retrieveCart/{userName}")
  public List <Book> getUserCart (@PathVariable String userName){
      List <Book> cart = userRepo.findCartByUser(userName);
      
      if (cart.isEmpty()){
          System.out.println("Cart empty");
      }
      
      return cart;
  }

  //@RequestMapping (value = "/addToCart/{id}/{userName}", method = RequestMethod.POST)
//  @PostMapping("/addToCart/{userName}")
//  public String addBookToCart (@RequestBody CartItem item, @PathVariable String userName) {
//	  Optional<User> currentUser = userRepo.findById(userName);
//      List<CartItem> cart = cartRepo.findByUser(currentUser);
//      
//      cart.add(item);
//      cartRepo.saveAll(cart);
//
//      //System.out.println( "Book was added to cart");
//      return "Book added to cart";
//  }
//
//  //@RequestMapping (value = "/dltFromCart/{productName}/{userName}", method = RequestMethod.DELETE)
//  @DeleteMapping("/dltFromCart/{userName}")
//  public String dltFromCart (@RequestBody CartItem item, @PathVariable("userName") String userName){
//      List<CartItem> cart =  this.cartRepo.findByUser(userName); 
//      //long numBooks = cartRepo.count();
//      
//      cartRepo.delete(item);
//      //numBooks--;
//
//      cart = this.cartRepo.saveAll(cart);
//
//      //System.out.println(item.productName + " deleted");//prints in java console
//      return "Book deleted from cart\n";
//  }
}
