package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.OrderDetails;
import com.example.projectShopOnline.entities.dto.respository.OrderDetailsResDTO;
import com.example.projectShopOnline.mapper.OrderDetailsMapper;
import com.example.projectShopOnline.repository.OrderDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetailsResDTO saveOderDetails(OrderDetailsResDTO orderDetailsResDTO) {
        OrderDetails orderDetails = OrderDetailsMapper.INSTANCE.toEntity(orderDetailsResDTO);
        OrderDetails saveOrderDetails = orderDetailsRepository.save(orderDetails);
        return OrderDetailsMapper.INSTANCE.toDTO(saveOrderDetails);
    }

    public OrderDetailsResDTO updateOrderDetails(int id,OrderDetailsResDTO orderDetailsResDTO) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElse(null);
        orderDetails.setQuantity(orderDetailsResDTO.getQuantity());
        orderDetails.setPrice(orderDetailsResDTO.getPrice());
        orderDetails = orderDetailsRepository.save(orderDetails);
        return OrderDetailsMapper.INSTANCE.toDTO(orderDetails);
    }

    public List<OrderDetailsResDTO> getAllOrderDetails() {
        return orderDetailsRepository.findAll().stream()
                .map(OrderDetailsMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDetailsResDTO findById(int id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElse(null);
        return OrderDetailsMapper.INSTANCE.toDTO(orderDetails);
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
