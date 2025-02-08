package com.example.Ecommerce.repoitory;


import com.example.Ecommerce.model.StoreMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreMovementRepository extends JpaRepository<StoreMovement, Integer> {
}