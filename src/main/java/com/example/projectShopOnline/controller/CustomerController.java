package com.example.projectShopOnline.controller;


import com.example.projectShopOnline.entities.Customer;
import com.example.projectShopOnline.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer saveCustomer = customerService.saveOrUpdate(customer);
        if (saveCustomer == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(saveCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        Customer saveCustomer = customerService.saveOrUpdate(customer);
        if (saveCustomer == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(saveCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        boolean checkResult = customerService.delete(id);
        if (checkResult) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
