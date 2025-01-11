package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.Customer;
import com.example.projectShopOnline.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }

    public Boolean delete(int id) {
        boolean checkExists = customerRepository.existsById(id);
        if (checkExists) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
