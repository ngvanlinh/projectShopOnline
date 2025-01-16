package com.example.projectShopOnline.mapper;

import com.example.projectShopOnline.entities.Order;
import com.example.projectShopOnline.entities.dto.respository.OrderResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderResDTO toDTO(Order order);
    Order toEntity(OrderResDTO orderResDTO);
}
