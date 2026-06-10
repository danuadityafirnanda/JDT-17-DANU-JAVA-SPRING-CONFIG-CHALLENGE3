package com.indivaragroup.jdt17.spring.dasar.config.challenge.three.service;

import com.indivaragroup.jdt17.spring.dasar.config.challenge.three.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;


    @Test
    void testCalculateFinalPrice_priceLessThanZero() {
        Product product = new Product("Milk", -100, 2, 0);
        assertThrows(IllegalArgumentException.class, () -> productService.calculateFinalPrice(product));
    }

    @Test
    void testCalculateFinalPrice_quantityZero() {
        Product product = new Product("Milk", 10000, 0, 0);
        assertThrows(IllegalArgumentException.class, () -> productService.calculateFinalPrice(product));
    }

    @Test
    void testCalculateFinalPrice_discountLessThanZero() {
        Product product = new Product("Milk", 10000, 2, -5);
        assertThrows(IllegalArgumentException.class, () -> productService.calculateFinalPrice(product));
    }

    @Test
    void testCalculateFinalPrice_discountGreaterThan100() {
        Product product = new Product("Milk", 10000, 2, 105);
        assertThrows(IllegalArgumentException.class, () -> productService.calculateFinalPrice(product));
    }
}
