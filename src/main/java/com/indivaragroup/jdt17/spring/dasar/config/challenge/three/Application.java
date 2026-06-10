package com.indivaragroup.jdt17.spring.dasar.config.challenge.three;

import com.indivaragroup.jdt17.spring.dasar.config.challenge.three.model.Product;
import com.indivaragroup.jdt17.spring.dasar.config.challenge.three.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        run(context);
    }

    public static void run(ApplicationContext context){
        ProductService productService = context.getBean(ProductService.class);

        Product product = new Product("Milk", 10000, 2, 0);
        double finalPrice = productService.calculateFinalPrice(product);

        System.out.println("\nProduct: " + product.getName());
        System.out.println("Final Price: " + finalPrice);
    }
}
