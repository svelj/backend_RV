package com.example.revert.service.impl;

import com.example.revert.model.User;
import com.example.revert.repository.ListingRepository;
import com.example.revert.service.ListingService;
import com.example.revert.model.Listing;
import com.example.revert.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService {

    private final UserService userService;
    private final ListingRepository listingRepository;
    public ListingServiceImpl(UserService userService, ListingRepository listingRepository) {
        this.userService = userService;
        this.listingRepository = listingRepository;
    }

    @Override
    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    @Override
    public Listing findById(Long id) {
        return listingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Invalid id lisiting"));
    }

    @Override
    public List<Listing> findByTitle(String title) {
        return listingRepository.findByTitle(title);
    }


    @Override
    public Listing save(String title, String category, String description,Double price, Long userId) {
        User user = userService.findById(userId);
        Listing listing = new Listing(title,category,description,price,user);
        return listingRepository.save(listing);
    }

    @Override
    public Listing update(Long id, String title, String category, String description, Double price, Long userId) {
        Listing listing= this.findById(id);
        User user =  userService.findById(userId);
        listing.setTitle(title);
        listing.setCategory(category);
        listing.setPrice(price);
        listing.setDescription(description);
        listing.setUser(user);
        return listingRepository.save(listing);
    }
    @Override
    public void delete(Long id) {
        Listing listing= this.findById(id);
        listingRepository.delete(listing);
    }
}
