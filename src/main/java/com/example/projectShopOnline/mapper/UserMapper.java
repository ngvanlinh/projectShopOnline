package com.example.projectShopOnline.mapper;

import com.example.projectShopOnline.entities.User;
import com.example.projectShopOnline.entities.dto.respository.UserResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserResDTO toDTO(User user);
    User toENtity(UserResDTO userResDTO);
}
