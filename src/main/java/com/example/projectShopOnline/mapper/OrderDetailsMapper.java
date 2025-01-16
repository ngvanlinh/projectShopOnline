package com.example.projectShopOnline.mapper;

import com.example.projectShopOnline.entities.OrderDetails;
import com.example.projectShopOnline.entities.dto.respository.OrderDetailsResDTO;
import org.mapstruct.factory.Mappers;

public interface OrderDetailsMapper {
    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);
    OrderDetailsResDTO toDTO(OrderDetails orderDetails);
    OrderDetails toEntity(OrderDetailsResDTO orderDetailsResDTO);
}
