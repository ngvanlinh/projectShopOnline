package com.example.projectShopOnline.mapper;

import com.example.projectShopOnline.entities.ImageProduct;
import com.example.projectShopOnline.entities.dto.respository.ImageProductResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageProductMapper {
    ImageProductMapper INSTANCE = Mappers.getMapper(ImageProductMapper.class);

    ImageProductResDTO toDTO(ImageProduct imageProduct);

    ImageProduct toEntity(ImageProductResDTO imageProductResDTO);
}
