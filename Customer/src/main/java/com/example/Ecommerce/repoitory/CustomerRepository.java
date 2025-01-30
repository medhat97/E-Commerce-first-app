package com.example.Ecommerce.repoitory;

import com.example.Ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    // Find by email
    Optional<Customer> findByEmail(String email);

    // Find by name
    Optional<Customer> findByName(String name);
    @Modifying
    @Transactional
    @Query("DELETE FROM Customer m WHERE m.name = :name")
    void deleteByName(String name);

}