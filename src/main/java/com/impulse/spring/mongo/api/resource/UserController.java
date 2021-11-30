package com.impulse.spring.mongo.api.resource;

import com.impulse.spring.mongo.api.model.Cart;
import com.impulse.spring.mongo.api.model.User;
import com.impulse.spring.mongo.api.repository.CartRepo;
import com.impulse.spring.mongo.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartRepo cartRepo;

    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user){
        Cart cart = new Cart();
        user.setCart(cart);
        cartRepo.save(cart);
        userRepo.save(user);
        return "Saved user!";
    }
}
