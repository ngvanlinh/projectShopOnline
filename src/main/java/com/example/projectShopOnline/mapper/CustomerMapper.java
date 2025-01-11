package com.example.projectShopOnline.mapper;

import com.example.projectShopOnline.entities.Customer;
import com.example.projectShopOnline.entities.dto.respository.CustomerResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResDTO toDTO(Customer customer);

    Customer toEntity(CustomerResDTO productDTO);
}
