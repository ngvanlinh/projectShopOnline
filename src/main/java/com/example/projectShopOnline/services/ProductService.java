package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.Product;
import com.example.projectShopOnline.entities.dto.respository.ProductResDTO;
import com.example.projectShopOnline.entities.enums.Category;
import com.example.projectShopOnline.mapper.ProductMapper;
import com.example.projectShopOnline.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResDTO> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductResDTO saveProduct(ProductResDTO productResDTO) {
        Product product = ProductMapper.INSTANCE.toENtity(productResDTO);
        Product saveProducts = productRepository.save(product);
        return ProductMapper.INSTANCE.toDTO(saveProducts);
    }

    public ProductResDTO update(int  id,ProductResDTO productResDTO) {
        Product product = productRepository.findById(id).orElse(null);
        product.setName(productResDTO.getName());
        product.setBrand(product.getBrand());
        product.setModel(product.getModel());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        product.setQuantity(product.getQuantity());
        product = productRepository.save(product);
        return ProductMapper.INSTANCE.toDTO(product);
    }

    public Boolean delete(int id) {
        boolean checkResult = productRepository.existsById(id);
        if (checkResult) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
