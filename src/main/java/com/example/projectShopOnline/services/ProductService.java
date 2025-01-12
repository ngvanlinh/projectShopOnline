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

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public Boolean delete(int id) {
        boolean checkResult = productRepository.existsById(id);
        if (checkResult) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Product> searchByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        return productRepository.searchByName(name, pageable);
    }

    public Page<Product> searchByCategory(Category category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return productRepository.searchByCategory(category, pageable);
    }
}
