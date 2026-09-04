package com.springboot.inception.config;

import com.springboot.inception.notification.NotificationService;
import com.springboot.inception.notification.impl.EmailNotification;
import com.springboot.inception.notification.impl.SmsNotification;
import com.springboot.inception.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    private final EmailNotification emailNotification;
    private final SmsNotification smsNotification;

    BeanConfig(EmailNotification emailNotification, SmsNotification smsNotification) {
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
    }

    @Bean
    @Scope("singleton")
    // This holds priority over @Component annotation in PaymentService class
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public NotificationService notificationService() {
        return emailNotification;
    }
}
