package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.OrderDetails;
import com.example.projectShopOnline.services.OrderDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @Operation(summary = "List All Order Details", description = "Send request via this API to get all order details list")
    @GetMapping("/all")
    public ResponseEntity<List<OrderDetails>> getOrderDetails() {
        List result = orderDetailsService.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Get Order Details", description = "Send a request via this API to get order details information")
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable int id) {
        OrderDetails orderDetails = orderDetailsService.findById(id);
        if (orderDetails == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderDetails);
    }

    @Operation(summary = "Add New Order Details", description = "Send requests via this API to add order details information")
    @PostMapping
    public ResponseEntity<OrderDetails> saveOrderDetails(OrderDetails orderDetails) {
        OrderDetails orderD = orderDetailsService.save(orderDetails);
        if (orderD == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orderD);
    }

    @Operation(summary = "Update OrderDetails Details", description = "Send a request via this API to edit order details information")
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable int id, @RequestBody OrderDetails orderDetails) {
        orderDetails.setId(id);
        OrderDetails orderUpdate = orderDetailsService.update(orderDetails);
        if (orderUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderUpdate);
    }

    @Operation(summary = "Delete Order Details", description = "Send a request via this API to delete order details information")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderDetails(@PathVariable int id) {
        boolean result = orderDetailsService.delete(id);
        if (result) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
