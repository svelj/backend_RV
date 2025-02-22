package com.example.revert.service;

import com.example.revert.model.Listing;
import com.example.revert.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    Optional<User> findByUsername(String username);

    void deleteUser(Long id);

    List<Listing> getUserListings(Long id);
    boolean validatePassword(User user, String rawPassword);

    User findById(Long id);

}
