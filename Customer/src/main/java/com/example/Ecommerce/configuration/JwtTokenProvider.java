package com.example.Ecommerce.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String JWT_SECRET = "yourjwtsecretkeyyourjwtsecretkeyyourjwtsecretkeyyourjwtsecretkey"; // You should store this securely
    private final long JWT_EXPIRATION = 86400000; // 1 day in milliseconds

    public String generateToken(LoginRequest userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }
}