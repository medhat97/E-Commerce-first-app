package com.example.Ecommerce.controller;

import com.example.Ecommerce.configuration.JwtResponse;
import com.example.Ecommerce.configuration.JwtTokenProvider;
import com.example.Ecommerce.configuration.LoginRequest;
import com.example.Ecommerce.dto.CustomerDto;
import com.example.Ecommerce.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class CustomerController {

    private final CustomerService customerService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public CustomerController(CustomerService customerService ,AuthenticationManager authenticationManager ,JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.customerService = customerService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CustomerDto customer) {
        customerService.register(customer);
        return ResponseEntity.ok(Map.of("message", "User registered successfully!"));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok(new JwtResponse(customerService.login(loginRequest)));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}