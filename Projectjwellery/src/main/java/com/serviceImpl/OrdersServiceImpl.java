package com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Orders;
import com.entity.Product;
import com.repository.OrdersRepository;
import com.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersRepository ordersRepository;


    
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(int orderId) {
        return ordersRepository.findById(orderId);
    }
    
    
    public List<Product> getFoodItemsByCustomerOrderId(int orderId, int customerId) {
        Optional<Orders> orderOptional = ordersRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Orders order = orderOptional.get();
          
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
    }
    
   
    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders updateOrder(int orderId, Orders updatedOrder) {
        if (!ordersRepository.existsById(orderId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        updatedOrder.setOrderId(orderId);
        return ordersRepository.save(updatedOrder);
    }

    public boolean deleteOrder(int orderId) {
        ordersRepository.deleteById(orderId);
        return true;
    }
}

