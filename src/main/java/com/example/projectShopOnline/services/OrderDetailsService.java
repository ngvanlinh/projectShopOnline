package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.OrderDetails;
import com.example.projectShopOnline.repository.OrderDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public OrderDetails update(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails findById(int id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public Boolean delete(int id) {
        boolean checkResult = orderDetailsRepository.existsById(id);
        if (checkResult) {
            orderDetailsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
