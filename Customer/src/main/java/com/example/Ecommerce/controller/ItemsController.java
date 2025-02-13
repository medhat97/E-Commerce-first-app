package com.example.Ecommerce.controller;


import com.example.Ecommerce.configuration.JwtTokenProvider;
import com.example.Ecommerce.model.items;
import com.example.Ecommerce.service.itemservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemsController {

    @Autowired
    private JwtTokenProvider jwtUtil;

    @Autowired
    private  itemservices itemService;

    @GetMapping("/items")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        try {
//            if (authHeader == null || !authHeader.startsWith("Bearer "))
//            {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid token");
//            }
            jwtUtil.extractEmail(authHeader);
            List<items> items = itemService.getAllitems();
            return ResponseEntity.ok(items);

//            return ResponseEntity.ok("Your token is okay, user: " + email);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
    @GetMapping("/test-items-no-token")
    public ResponseEntity<?> getitems(@RequestParam String store_id) {
        try {
            List<items> items = itemService.getAllitems();
            List<items> items2 = itemService.getItemsByStoreNumber(store_id);

            return ResponseEntity.ok(items2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid");
        }
    }
}
