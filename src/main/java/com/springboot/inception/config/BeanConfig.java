package com.springboot.inception.config;

import com.springboot.inception.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    // This holds priority over @Component annotation in PaymentService class
    public PaymentService paymentService() {
        return new PaymentService();
    }
}
