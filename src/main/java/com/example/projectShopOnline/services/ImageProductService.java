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

    public ImageProductResDTO findById(int id) {
        ImageProduct imageProduct = imageProductRepository.findById(id).orElse(null);
        return ImageProductMapper.INSTANCE.toDTO(imageProduct);
    }

    public ImageProductResDTO saveImageProducts( ImageProductResDTO imageProductResDTO) {
        ImageProduct imageProduct = ImageProductMapper.INSTANCE.toEntity(imageProductResDTO);
        ImageProduct save = imageProductRepository.save(imageProduct);
        return ImageProductMapper.INSTANCE.toDTO(save);
    }
    public ImageProductResDTO updateImage(int id,ImageProductResDTO imageProductResDTO){
        ImageProduct imageProduct = imageProductRepository.findById(id).orElse(null);
        imageProduct.setImage(imageProductResDTO.getImage());
        imageProduct = imageProductRepository.save(imageProduct);
        return ImageProductMapper.INSTANCE.toDTO(imageProduct);
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
