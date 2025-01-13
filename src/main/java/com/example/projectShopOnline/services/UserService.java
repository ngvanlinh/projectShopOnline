package com.example.projectShopOnline.services;
import com.example.projectShopOnline.entities.User;
import com.example.projectShopOnline.entities.dto.respository.UserResDTO;
import com.example.projectShopOnline.mapper.UserMapper;
import com.example.projectShopOnline.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResDTO> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public UserResDTO findById(int id) {
        User user = userRepository.findById(id)
                .orElse(null);
        return UserMapper.INSTANCE.toDTO(user);
    }

    public UserResDTO createUser(UserResDTO userResDTO) {
        User user = UserMapper.INSTANCE.toENtity(userResDTO);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.toDTO(user);
    }

    public UserResDTO updateUser(int id, UserResDTO userDTO) {
        User user = userRepository.findById(id)
                .orElse(null);
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return UserMapper.INSTANCE.toDTO(user);
    }

    public Boolean delete(int id) {
        boolean checkResult = userRepository.existsById(id);
        if (checkResult) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
