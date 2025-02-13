package com.example.Ecommerce.repoitory;

import com.example.Ecommerce.model.items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface itemsRepository extends JpaRepository<items, Integer> {
    List<items> findByStoreNumber(String storeNumber);
}
