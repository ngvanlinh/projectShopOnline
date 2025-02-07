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
    private Integer ProductID;
    private String ProductName;
    private String Brand;
    private String Model;
    private String description;
    private Double price;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category")
    private Category category;

    @Column(name = "create_at")
    @CreatedDate
    private LocalDateTime createdAt;


}
