package com.springboot.inception.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void pay() {
        System.out.println("Payment processed successfully.");
    }
}
