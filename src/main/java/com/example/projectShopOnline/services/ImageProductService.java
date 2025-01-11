package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.ImageProduct;
import com.example.projectShopOnline.repository.ImageProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageProductService {
    private final ImageProductRepository imageProductRepository;

    public ImageProductService(ImageProductRepository imageProductRepository) {
        this.imageProductRepository = imageProductRepository;
    }

    public Page<ImageProduct> findAll(Pageable pageable) {
        return imageProductRepository.findAll(pageable);
    }

    public ImageProduct findById(int id) {
        return imageProductRepository.findById(id).orElse(null);
    }

    public ImageProduct saveOrUpdate(ImageProduct imageProduct) {
        return imageProductRepository.save(imageProduct);
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
