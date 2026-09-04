package com.springboot.inception.payment;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void pay() {
        System.out.println("Payment processed successfully.");
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("PaymentService bean has been initialized.");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("PaymentService bean is about to be destroyed.");
    }
}
