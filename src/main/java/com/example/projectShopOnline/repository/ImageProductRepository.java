package com.example.projectShopOnline.repository;

import com.example.projectShopOnline.entities.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageProductRepository extends JpaRepository<ImageProduct, Integer> {
}
