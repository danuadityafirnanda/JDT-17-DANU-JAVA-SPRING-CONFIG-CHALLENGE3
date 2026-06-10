package com.indivaragroup.jdt17.spring.dasar.config.challenge.three.configuration;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "product")
public class ProductConfig {
    private double defaultDiscount;
    private double taxPercentage;
}
