package com.example.projectShopOnline.entities.dto.respository;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductResDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String brand;
    private String model;
    private String description;
    private Double price;
    private int quantity;
    private LocalDateTime createdAt;
}
