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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.entity.Orders;
import com.entity.Product;
import com.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

 

    @Autowired
    private OrdersService ordersService;

 

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

 

    @GetMapping("/getorderbyid/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int orderId) {
        Optional<Orders> order = ordersService.getOrderById(orderId);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 

    @GetMapping("/getFoodItemsByCustomerOrderId/{orderId}")
    public ResponseEntity<List<Product>> getFoodItemsByCustomerOrderId(
            @PathVariable("orderId") int orderId,
            @RequestParam("customerId") int customerId) {
        List<Product> foodItems = ordersService.getFoodItemsByCustomerOrderId(orderId, customerId);
        return ResponseEntity.ok(foodItems);
    }

 

    @PostMapping("/placeorder")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrder = ordersService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

 

    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable int orderId, @RequestBody Orders updatedOrder) {
        Orders updated = ordersService.updateOrder(orderId, updatedOrder);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
        boolean deleted = ordersService.deleteOrder(orderId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}