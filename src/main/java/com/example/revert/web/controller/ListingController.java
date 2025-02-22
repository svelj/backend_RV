package com.example.revert.web.controller;

import com.example.revert.model.Listing;
import com.example.revert.model.dto.ListingRequest;
import com.example.revert.service.ListingService;
import com.example.revert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListIterator;

@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true")
@RestController
@RequestMapping("/listing")
public class ListingController {
    private final ListingService listingService;
    private final UserService userService;
    public ListingController(ListingService listingService, UserService userService) {
        this.listingService = listingService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<Listing> allListings(){
        return listingService.findAll();
    }


    @PostMapping("/add")
    public Listing addListing(@RequestBody ListingRequest request){
        return listingService.save(
                request.getTitle(),
                request.getCategory(),
                request.getDescription(),
                request.getPrice(),
                request.getUserId()
        );

    }
    @DeleteMapping("/delete/{id}")
    public void deleteListing(@PathVariable Long id)
    {
        listingService.delete(id);
    }
}
