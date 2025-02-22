package com.example.revert.service;

import com.example.revert.model.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingService {

    List<Listing> findAll();
    Listing findById(Long id);

    List<Listing> findByTitle(String title);


    Listing save(String title, String category, String description,Double price, Long userId);

    Listing update(Long id, String title, String category, String description,Double price, Long userId);

    void delete(Long id);

}
