package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.OrderDetails;
import com.example.projectShopOnline.entities.dto.respository.OrderDetailsResDTO;
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
    public ResponseEntity<List<OrderDetailsResDTO>> getOrderDetails() {

        return ResponseEntity.ok(orderDetailsService.getAllOrderDetails());
    }

    @Operation(summary = "Get Order Details", description = "Send a request via this API to get order details information")
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsResDTO> getOrderDetailsById(@PathVariable int id) {
        OrderDetailsResDTO orderDetailsResDTO = orderDetailsService.findById(id);
        if (orderDetailsResDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderDetailsResDTO);
    }

    @Operation(summary = "Add New Order Details", description = "Send requests via this API to add order details information")
    @PostMapping
    public ResponseEntity<OrderDetailsResDTO> saveOrderDetails(OrderDetailsResDTO orderDetailsResDTO) {
        OrderDetailsResDTO orderD = orderDetailsService.saveOderDetails(orderDetailsResDTO);
        if (orderD == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orderD);
    }

    @Operation(summary = "Update OrderDetails Details", description = "Send a request via this API to edit order details information")
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailsResDTO> updateOrderDetails(@PathVariable int id, @RequestBody OrderDetailsResDTO orderDetailsResDTO) {
        orderDetailsResDTO.setId(id);
        OrderDetailsResDTO orderUpdate = orderDetailsService.updateOrderDetails(id,orderDetailsResDTO);
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
