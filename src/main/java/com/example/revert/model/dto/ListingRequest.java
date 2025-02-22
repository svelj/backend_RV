package com.example.revert.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListingRequest {
    private String title;
    private String category;
    private String description;
    private Double price;
    private Long userId;
}