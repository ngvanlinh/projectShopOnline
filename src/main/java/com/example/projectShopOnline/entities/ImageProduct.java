package com.example.projectShopOnline.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "I_ProductID")
    private Product product;

}
