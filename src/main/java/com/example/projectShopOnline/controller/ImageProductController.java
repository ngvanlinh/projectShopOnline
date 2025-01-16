package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.ImageProduct;
import com.example.projectShopOnline.entities.dto.respository.ImageProductResDTO;
import com.example.projectShopOnline.services.ImageProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageProductController {
    private final ImageProductService imageProductService;

    public ImageProductController(ImageProductService imageProductService) {
        this.imageProductService = imageProductService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ImageProductResDTO>> getAllImageProducts( ) {
        return ResponseEntity.ok(imageProductService.getAllImageProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageProductResDTO> getById(@PathVariable int id) {
        ImageProductResDTO imageProductResDTO = imageProductService.findById(id);
        if (imageProductResDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imageProductResDTO);
    }

    @PostMapping
    public ResponseEntity<ImageProductResDTO> create(@RequestBody ImageProductResDTO imageProductResDTO) {
        ImageProductResDTO save = imageProductService.saveImageProducts(imageProductResDTO);
        if (save == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageProductResDTO> update(@PathVariable int id, @RequestBody ImageProductResDTO imageProductResDTO) {
        imageProductResDTO.setId(id);
        ImageProductResDTO update = imageProductService.saveImageProducts(imageProductResDTO);
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
