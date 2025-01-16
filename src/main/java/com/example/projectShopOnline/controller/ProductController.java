package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.Product;
import com.example.projectShopOnline.entities.dto.respository.ProductResDTO;
import com.example.projectShopOnline.entities.enums.Category;
import com.example.projectShopOnline.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResDTO>> getProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductResDTO> addProduct(@RequestBody ProductResDTO productResDTO) {
        ProductResDTO saveProduct = productService.saveProduct(productResDTO);
        if (saveProduct == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(saveProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResDTO> updateProduct(@PathVariable int id, @RequestBody ProductResDTO productResDTO) {
        productResDTO.setId(id);
        ProductResDTO editProduct = productService.update(id,productResDTO);
        if (editProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        boolean checkExists = productService.delete(id);
        if (checkExists) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
