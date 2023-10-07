package com.entity;





import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

 

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	private String productName;

	@ManyToOne
    @JoinColumn(name = "category_id") // Map to the category_id column in the FoodItems table
	//@JsonIgnore
	private Category category;

	private int quantity;
	private double price;
	private String productImage;

//	@ManyToOne
//	private Cart cart;
//	
//	public Cart getCart() {
//		return cart;
//	}
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
//				+ ", quantity=" + quantity + ", price=" + price + ", productImage=" + productImage + "]";
//	}
//	
}
