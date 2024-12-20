package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.Order;
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
    public ResponseEntity<List<Order>> getOrders() {
        List result = orderService.findAll();
        if (result.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Get Order Details", description = "Send a request via this API to get orders information")
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Order result = orderService.findById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @Operation(method = "POST", summary = "Add New Order", description = "Send requests via this API to add orders information")
    @PostMapping
    public Order saveOrder(Order order) {
        return orderService.save(order);
    }

    @Operation(summary = "Update Order Details", description = "Send a request via this API to edit orders information")
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        order.setOrderID(id);
        Order result = orderService.save(order);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Delete Order", description = "Send a request via this API to delete orders information")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        boolean result = orderService.delete(id);
        if (result) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}

