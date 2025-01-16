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
public class OrderResDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int totalAmount;
    private LocalDateTime orderDate;
}
