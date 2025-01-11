package com.example.projectShopOnline.entities;

import com.example.projectShopOnline.entities.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private String model;
    private String description;
    private Double price;
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category")
    private Category category;

    @Column(name = "create_at")
    @CreatedDate
    private LocalDateTime createdAt;


}
