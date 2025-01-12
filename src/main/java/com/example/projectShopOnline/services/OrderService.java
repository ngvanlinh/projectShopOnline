package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.Order;
import com.example.projectShopOnline.entities.dto.respository.OrderResDTO;
import com.example.projectShopOnline.mapper.OrderMapper;
import com.example.projectShopOnline.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResDTO save(OrderResDTO orderResDTO) {
        Order order = OrderMapper.INSTANCE.toEntity(orderResDTO);
        Order saveOrder = orderRepository.save(order);
        return OrderMapper.INSTANCE.toDTO(saveOrder);
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public List<OrderResDTO> getaAllOrder() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
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
