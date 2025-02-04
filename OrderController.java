package com.example.ordertracking.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*") // Allow frontend requests
public class OrderController {

    // Simulated database
    private static final List<Map<String, String>> orders = Arrays.asList(
        Map.of("order_id", "ORD12345", "book_name", "The Great Gatsby", "status", "Shipped", "delivery_date", "2025-02-05"),
        Map.of("order_id", "ORD67890", "book_name", "1984", "status", "Delivered", "delivery_date", "2025-01-28"),
        Map.of("order_id", "ORD11111", "book_name", "To Kill a Mockingbird", "status", "Processing", "delivery_date", "2025-02-10")
    );

    @GetMapping("/{orderId}")
    public Map<String, String> getOrder(@PathVariable String orderId) {
        return orders.stream()
                     .filter(order -> order.get("order_id").equals(orderId))
                     .findFirst()
                     .orElse(Collections.singletonMap("error", "Order not found"));
    }
}
