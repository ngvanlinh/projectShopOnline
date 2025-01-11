package com.example.projectShopOnline.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String FullName;
    private String Email;
    private String Address ;

    @Column(name = "phone_number")
    private int phoneNumber;

}
