package com.indivaragroup.jdt17.spring.dasar.config.challenge.three.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discountPercentage;
}
