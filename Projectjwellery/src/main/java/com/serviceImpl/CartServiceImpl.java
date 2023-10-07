package com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Cart;
import com.repository.CartRepository;
import com.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartrepo;
	

	    @Autowired
	    private CartRepository cartRepository;

	    public List<Cart> getAllCarts() {
	        return cartRepository.findAll();
	    }

	    public Optional<Cart> getCartById(int cartId) {
	        return cartRepository.findById(cartId);
	    }

	    public Cart createCart(Cart cart) {
	        return cartRepository.save(cart);
	    }

	    public Cart updateCart(int cartId, Cart updatedCart) {
	        if (!cartRepository.existsById(cartId)) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
	        }
	        updatedCart.setCartId(cartId);
	        return cartRepository.save(updatedCart);
	    }

	    public boolean deleteCart(int cartId) {
	        cartRepository.deleteById(cartId);
	        return true;
	    }

 
}