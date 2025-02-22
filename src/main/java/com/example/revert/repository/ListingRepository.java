package com.example.revert.repository;

import com.example.revert.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing,Long> {
    List<Listing> findByTitle(String title);
}
