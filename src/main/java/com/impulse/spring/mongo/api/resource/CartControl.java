package com.impulse.spring.mongo.api.resource;

//Imports
import java.util.List;
import java.util.Optional;

import com.impulse.spring.mongo.api.model.*;
import com.impulse.spring.mongo.api.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//Controller begins
@Component
@RestController
public class CartControl {

  @Autowired
  private CartRepo cartRepo;
  
  CartControl (CartRepo cartRepo){
	  this.cartRepo = cartRepo;
  }

  @PostMapping("/makeCart/{user}")
  public String makeCart(@RequestBody CartItem item, @PathVariable String userName) {
      CartItem cart = new CartItem (item.id, item.author,item.productName);
      cartRepo.save(cart);
      return "Cart for " + userName + " created";
  }
  
  @GetMapping("/retrieveCart/{user}")
  public List<CartItem> getUserCart (@PathVariable String userName){
      List <CartItem> cart = cartRepo.findByUserName(userName);
      return cart;
  }
  

  @PostMapping("/addToCart/{userName}")
  public String addBookToCart (@RequestBody CartItem item, @PathVariable String userName) {
	  List<CartItem> cart = cartRepo.findByUserName(userName);
	  
	  cart.add(item);
      cartRepo.save(cart);
      
      return "The book \"" + item.productName + "\" added to cart";
  }

  @DeleteMapping("/dltFromCart/{userName}")
  public String dltFromCart (@RequestBody CartItem item, @PathVariable("userName") String userName){
	  List<CartItem> cart = cartRepo.findByUserName(userName);
      
      cartRepo.delete(item);
      cartRepo.save(cart);

      return "The book \"" + item.productName + "\" was deleted from the cart";
  }
  
} //Controller ends
