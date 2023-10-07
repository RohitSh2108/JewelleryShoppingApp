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
import com.entity.Customer;
import com.service.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomer( @PathVariable int customerId, @RequestBody @Valid Customer updatedCustomer  ) {
        Customer customer = customerService.updateCustomer(customerId, updatedCustomer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
