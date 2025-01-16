package com.example.projectShopOnline.entities.dto.respository;

import com.example.projectShopOnline.entities.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsResDTO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime paymentDate;
    private int amount;
    private PaymentMethod paymentMethod;
}
