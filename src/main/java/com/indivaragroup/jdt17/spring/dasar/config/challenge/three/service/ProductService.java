package com.indivaragroup.jdt17.spring.dasar.config.challenge.three.service;

import com.indivaragroup.jdt17.spring.dasar.config.challenge.three.configuration.ProductConfig;
import com.indivaragroup.jdt17.spring.dasar.config.challenge.three.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductConfig productConfig;

    public double calculateFinalPrice(Product product) {
        checkProduct(product);

        double discountPercentage = product.getDiscountPercentage();
        if (discountPercentage == 0) {
            discountPercentage = productConfig.getDefaultDiscount();
        }

        /*
        subtotal = price * quantity
        discount = subtotal * discountPercentage / 100
        afterDiscount = subtotal - discount
        tax = afterDiscount * taxPercentage / 100
        finalPrice = afterDiscount + tax
         */

        double subtotal = product.getPrice() * product.getQuantity();
        double discount = subtotal * discountPercentage / 100;
        double afterDiscount = subtotal - discount;
        double tax = afterDiscount * productConfig.getTaxPercentage() / 100;
        
        return afterDiscount + tax;
    }

    private void checkProduct(Product product) {
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to zero");
        }

        if (product.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (product.getDiscountPercentage() < 0 || product.getDiscountPercentage() > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
    }
}
