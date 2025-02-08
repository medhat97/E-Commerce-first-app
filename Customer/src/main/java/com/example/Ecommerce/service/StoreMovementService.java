package com.example.Ecommerce.service;

import com.example.Ecommerce.model.StoreMovement;
import com.example.Ecommerce.repoitory.StoreMovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreMovementService {
    private final StoreMovementRepository storeMovementRepository;

    public StoreMovementService(StoreMovementRepository storeMovementRepository) {
        this.storeMovementRepository = storeMovementRepository;
    }

    public List<StoreMovement> getAllMovements() {
        return storeMovementRepository.findAll();
    }
}
