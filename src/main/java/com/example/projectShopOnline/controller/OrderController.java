package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.Order;
import com.example.projectShopOnline.entities.dto.respository.OrderResDTO;
import com.example.projectShopOnline.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "List All Orders", description = "Send request via this API to get all orders list")
    @GetMapping("/all")
    public ResponseEntity<List<OrderResDTO>> getOrders() {
        return ResponseEntity.ok(orderService.getaAllOrder());
    }

    @Operation(summary = "Get Order Details", description = "Send a request via this API to get orders information")
    @GetMapping("/{id}")
    public ResponseEntity<OrderResDTO> getOrderById(@PathVariable int id) {
        OrderResDTO result = orderService.findById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @Operation(method = "POST", summary = "Add New Order", description = "Send requests via this API to add orders information")
    @PostMapping
    public OrderResDTO saveOrder(OrderResDTO orderResDTO) {
        return orderService.saveOrder(orderResDTO);
    }

    @Operation(summary = "Update Order Details", description = "Send a request via this API to edit orders information")
    @PutMapping("/{id}")
    public ResponseEntity<OrderResDTO> updateOrder(@PathVariable int id, @RequestBody OrderResDTO orderResDTO) {
        orderResDTO.setId(id);
        OrderResDTO result = orderService.update(id,orderResDTO);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Delete Order", description = "Send a request via this API to delete orders information")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id) {
        boolean result = orderService.delete(id);
        if (result) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}

