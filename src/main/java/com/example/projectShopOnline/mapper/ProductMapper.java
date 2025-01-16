package com.example.projectShopOnline.mapper;

import com.example.projectShopOnline.entities.Product;
import com.example.projectShopOnline.entities.dto.respository.ProductResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductResDTO toDTO(Product product);
    Product toENtity(ProductResDTO productResDTO);
}
