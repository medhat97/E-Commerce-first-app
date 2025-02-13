package com.example.Ecommerce.controller;

import com.example.Ecommerce.configuration.JwtTokenProvider;
import com.example.Ecommerce.model.StoreMovement;
import com.example.Ecommerce.service.StoreMovementService;
import com.example.Ecommerce.service.itemservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreMovementController {
    private final StoreMovementService storeMovementService;
    @Autowired
    private JwtTokenProvider jwtUtil;

    @Autowired
    private itemservices itemService;
    public StoreMovementController(StoreMovementService storeMovementService) {
        this.storeMovementService = storeMovementService;
    }

    // ✅ Endpoint to get all store movements
    @GetMapping("/movements")
    public ResponseEntity<?> getAllMovements(@RequestHeader("Authorization") String authHeader) {
        try {
//            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid token");
//            }

            // Remove "Bearer " prefix
            jwtUtil.extractEmail(authHeader); // Extract email from token
            List<StoreMovement> items = storeMovementService.getAllMovements();
            return ResponseEntity.ok(items);

//            return ResponseEntity.ok("Your token is okay, user: " + email);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
    @GetMapping("/test-movements-no-token")
    public ResponseEntity<?> getAllMovement() {
        try {
            List<StoreMovement> items = storeMovementService.getAllMovements();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid");
        }
    }

}