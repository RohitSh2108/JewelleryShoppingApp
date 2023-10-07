package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.entity.Customer;
import com.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/getAllcart")
    public ResponseEntity<List<Cart>> getAllCarts() {
    	List<Cart> cart = cartService.getAllCarts();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/getcartbyid{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable int cartId) {
       Optional<Cart> cart = cartService.getCartById(cartId);
        return cart.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createcart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
    	  Cart cartCreate = cartService.createCart(cart);
          return new ResponseEntity<>(cartCreate, HttpStatus.CREATED);
    }


    @PutMapping("/updatecart{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable int cartId, @RequestBody Cart updatedCart) {
    	 Cart cart = cartService.updateCart(cartId, updatedCart);
         return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping("/deletecart{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable int cartId) {
    	cartService.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}







