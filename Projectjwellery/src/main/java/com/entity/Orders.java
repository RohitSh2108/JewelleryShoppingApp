package com.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity

public class Orders {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int orderId;
	    private LocalDateTime date;
	    private String status;

	  //  @ManyToOne
	    
	 //   private Customer customer;
	    
	    @ManyToOne
	    @JoinColumn(name = "cart_id") // Map orderId to cartId
	    private Cart cart;
	    
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(name = "order_product",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "product_id"))
	    private List<Product> product; 
	    
	    public List<Product> getProduct() {
			return product;
		}

		public void setProduct(List<Product> product) {
			this.product = product;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
//
//		public Customer getCustomer() {
//			return customer;
//		}
//
//		public void setCustomer(Customer customer) {
//			this.customer = customer;
//		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}
	}

		
	    
	  

