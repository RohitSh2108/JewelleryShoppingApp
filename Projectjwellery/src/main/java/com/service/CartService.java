package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Cart;
import com.repository.CartRepository;


public interface CartService {

    

    public List<Cart> getAllCarts() ;
    public Optional<Cart> getCartById(int cartId) ;
    public Cart createCart(Cart cart) ;
    public Cart updateCart(int cartId, Cart updatedCart) ;
    public boolean deleteCart(int cartId) ;
}




