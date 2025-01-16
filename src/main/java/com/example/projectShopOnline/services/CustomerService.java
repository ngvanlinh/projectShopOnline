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

    public CustomerResDTO saveCustomer(CustomerResDTO customerResDTO) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerResDTO);
        Customer saveCustomer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toDTO(saveCustomer);
    }
    public CustomerResDTO upadateCustomer(int id,CustomerResDTO customerResDTO){
        Customer customer = customerRepository.findById(id).orElse(null);
        customer.setFullName(customerResDTO.getFullName());
        customer.setEmail(customerResDTO.getEmail());
        customer.setAddress(customerResDTO.getAddress());
        customer.setPhoneNumber(customer.getPhoneNumber());
        customer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toDTO(customer);

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
