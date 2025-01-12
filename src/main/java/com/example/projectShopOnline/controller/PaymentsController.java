package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.Payments;
import com.example.projectShopOnline.entities.dto.respository.PaymentsResDTO;
import com.example.projectShopOnline.services.PaymentsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }


    @Operation(summary = "List All Payments", description = "Send request via this API to get all payments list")
    @GetMapping("/all")
    public ResponseEntity<List<PaymentsResDTO>> getPayments() {
        return ResponseEntity.ok(paymentsService.getAllPayments());
    }

    @Operation(summary = "Get Payments", description = "Send a request via this API to get payments information")
    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPaymentsById(@PathVariable int paymentID) {
        Payments payment = paymentsService.findById(paymentID);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payment);
    }

    @Operation(summary = "Add New Payments", description = "Send requests via this API to add Payments information")
    @PostMapping
    public ResponseEntity<PaymentsResDTO> savePayments(PaymentsResDTO paymentsResDTO) {
        PaymentsResDTO save = paymentsService.save(paymentsResDTO);
        return ResponseEntity.ok(save);
    }

    @Operation(summary = "Update Payments", description = "Send a request via this API to edit payments information")
    @PutMapping("/{id}")
    public ResponseEntity<Payments> updatePayments(@PathVariable int id, @RequestBody Payments payments) {
        payments.setId(id);
        Payments orderUpdate = paymentsService.update(payments);
        if (orderUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderUpdate);
    }

    @Operation(summary = "Delete Payments", description = "Send a request via this API to delete payments information")
    @DeleteMapping("/{id}")
    public ResponseEntity deletePayments(@PathVariable Integer paymentID) {
        boolean result = paymentsService.delete(paymentID);
        if (result) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
