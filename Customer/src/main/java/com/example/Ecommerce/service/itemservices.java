package com.example.Ecommerce.service;

import com.example.Ecommerce.model.items;
import com.example.Ecommerce.repoitory.itemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemservices {
    @Autowired
    private itemsRepository deviceRepository;

    public List<items> getAllitems() {
        return deviceRepository.findAll();
    }


    public List<items> getItemsByStoreNumber(String storeNumber) {
        return deviceRepository.findByStoreNumber(storeNumber);
    }
}