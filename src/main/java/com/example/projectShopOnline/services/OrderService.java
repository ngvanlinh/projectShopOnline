package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.Order;
import com.example.projectShopOnline.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Boolean delete(int id) {
        boolean check = orderRepository.existsById(id);
        if (check) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
