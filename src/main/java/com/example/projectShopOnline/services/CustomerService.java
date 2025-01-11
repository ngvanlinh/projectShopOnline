package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.Customer;
import com.example.projectShopOnline.entities.dto.respository.CustomerResDTO;
import com.example.projectShopOnline.mapper.CustomerMapper;
import com.example.projectShopOnline.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResDTO> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public CustomerResDTO saveOrUpdate(CustomerResDTO customerResDTO) {
        Customer product = CustomerMapper.INSTANCE.toEntity(customerResDTO);
        Customer saveCustomer = customerRepository.save(product);
        return CustomerMapper.INSTANCE.toDTO(saveCustomer);
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
