package com.example.Ecommerce.repoitory;

import com.example.Ecommerce.model.items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemsRepository extends JpaRepository<items, Integer> {
}
