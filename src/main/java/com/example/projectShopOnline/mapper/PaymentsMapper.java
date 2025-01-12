package com.example.projectShopOnline.mapper;

import com.example.projectShopOnline.entities.Payments;
import com.example.projectShopOnline.entities.dto.respository.PaymentsResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentsMapper {
    PaymentsMapper INSTANCE = Mappers.getMapper(PaymentsMapper.class);
    PaymentsResDTO toDTO(Payments payments);
    Payments toEntity(PaymentsResDTO paymentsResDTO);
}
