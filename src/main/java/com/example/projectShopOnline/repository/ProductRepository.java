package com.example.projectShopOnline.repository;

import com.example.projectShopOnline.entities.Product;
import com.example.projectShopOnline.entities.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.ProductName LIKE %:name%")
    Page<Product> searchByName(@Param("name") String name, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.category LIKE %:category%" )
    Page<Product> searchByCategory(@Param("category") Category category, Pageable pageable);
}
