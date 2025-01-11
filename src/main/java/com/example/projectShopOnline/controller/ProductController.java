package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.Product;
import com.example.projectShopOnline.entities.enums.Category;
import com.example.projectShopOnline.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Product>> getProducts(Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
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
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saveProduct = productService.save(product);
        if (saveProduct == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(saveProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        product.setId(id);
        Product editProduct = productService.update(product);
        if (editProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        boolean checkExists = productService.delete(id);
        if (checkExists) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/searchName")
    public ResponseEntity<Page<Product>> searchProductByName(@RequestParam String name, @RequestParam Integer page, @RequestParam Integer size) {
        Page<Product> products = productService.searchByName(name, page, size);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/searchCategory")
    public ResponseEntity<Page<Product>> searchProductByCatId(@RequestParam Category category, @RequestParam Integer page, @RequestParam Integer size) {
        Page<Product> products = productService.searchByCategory(category, page, size);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
}
