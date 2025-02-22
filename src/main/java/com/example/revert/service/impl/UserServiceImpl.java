package com.example.revert.service.impl;

import com.example.revert.model.Listing;
import com.example.revert.service.UserService;
import com.example.revert.model.User;
import com.example.revert.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRepository.deleteById(id);
    }

    @Override
    public List<Listing> getUserListings(Long id) {
        User user = this.findById(id);
        return user.getListings();
    }

    @Override
    public boolean validatePassword(User user, String rawPassword) {
        return user.getPassword().equals(rawPassword);
    }

    @Override
    public User findById(Long id) {
        return  userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
}
