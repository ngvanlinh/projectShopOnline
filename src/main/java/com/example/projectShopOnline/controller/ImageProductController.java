package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.ImageProduct;
import com.example.projectShopOnline.services.ImageProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class ImageProductController {
    private final ImageProductService imageProductService;

    public ImageProductController(ImageProductService imageProductService) {
        this.imageProductService = imageProductService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ImageProduct>> getAllImageProducts(Pageable pageable) {
        Page<ImageProduct> imageProducts = imageProductService.findAll(pageable);
        if (imageProducts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(imageProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageProduct> getById(@PathVariable int id) {
        ImageProduct imageProduct = imageProductService.findById(id);
        if (imageProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imageProduct);
    }

    @PostMapping
    public ResponseEntity<ImageProduct> create(@RequestBody ImageProduct imageProduct) {
        ImageProduct save = imageProductService.saveOrUpdate(imageProduct);
        if (save == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageProduct> update(@PathVariable int id, @RequestBody ImageProduct imageProduct) {
        imageProduct.setId(id);
        ImageProduct update = imageProductService.saveOrUpdate(imageProduct);
        if (update == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        boolean delete = imageProductService.delete(id);
        if (delete) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
