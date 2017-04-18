package com.globomart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PricingServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApp.class, args);
    }
}



