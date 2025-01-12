package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.ImageProduct;
import com.example.projectShopOnline.entities.dto.respository.ImageProductResDTO;
import com.example.projectShopOnline.mapper.ImageProductMapper;
import com.example.projectShopOnline.repository.ImageProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageProductService {
    private final ImageProductRepository imageProductRepository;

    public ImageProductService(ImageProductRepository imageProductRepository) {
        this.imageProductRepository = imageProductRepository;
    }

    public List<ImageProductResDTO> getAllImageProducts() {
        return imageProductRepository.findAll()
                .stream()
                .map(ImageProductMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public ImageProduct findById(int id) {
        return imageProductRepository.findById(id).orElse(null);
    }

    public ImageProductResDTO saveImageProducts( ImageProductResDTO imageProductResDTO) {
        ImageProduct imageProduct = ImageProductMapper.INSTANCE.toEntity(imageProductResDTO);
        ImageProduct save = imageProductRepository.save(imageProduct);
        return ImageProductMapper.INSTANCE.toDTO(save);
    }

    public Boolean delete(int id) {
        boolean checkExists = imageProductRepository.existsById(id);
        if (checkExists) {
            imageProductRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
