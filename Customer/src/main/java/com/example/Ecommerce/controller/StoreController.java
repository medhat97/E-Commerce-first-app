package com.example.Ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Ecommerce.model.Store;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    @GetMapping("/stores")
    public List<Store> getAllStores() {
        return List.of(
                new Store("مخزن ١", "Main Development Store", "Building A, Floor 1", "John Doe"),
                new Store("ST02", "Mobile Testing Lab", "Building B, Floor 2", "Jane Smith"),
                new Store("ST03", "Hardware Testing Center", "Building A, Floor 3", "Mike Johnson"),
                new Store("ST04", "Research Lab", "Building C, Floor 1", "Sarah Wilson")
        );
    }
}