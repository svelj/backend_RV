package com.example.revert.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String category;
    private String description;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading to avoid unnecessary joins
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Listing(String title, String category, String description, double price, User user) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.price = price;
        this.user = user;
    }
}
