package com.example.projectShopOnline.controller;


import com.example.projectShopOnline.entities.Customer;
import com.example.projectShopOnline.entities.dto.respository.CustomerResDTO;
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
    public ResponseEntity<List<CustomerResDTO>> getAllCustomers() {
        List<CustomerResDTO> customers = customerService.getAllCustomer();
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
    public ResponseEntity<CustomerResDTO> createCustomer(@RequestBody CustomerResDTO customerResDTO) {
        CustomerResDTO saveCustomer = customerService.saveOrUpdate(customerResDTO);
        if (saveCustomer == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.saveOrUpdate(customerResDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResDTO> updateCustomer(@PathVariable int id, @RequestBody CustomerResDTO customerResDTO) {
        customerResDTO.setId(id);
        CustomerResDTO saveCustomer = customerService.saveOrUpdate(customerResDTO);
        if (saveCustomer == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.saveOrUpdate(customerResDTO));
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
