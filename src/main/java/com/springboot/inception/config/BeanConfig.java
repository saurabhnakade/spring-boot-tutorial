package com.springboot.inception.config;

import com.springboot.inception.notification.NotificationService;
import com.springboot.inception.notification.impl.EmailNotification;
import com.springboot.inception.notification.impl.SmsNotification;
import com.springboot.inception.payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;

@Configuration
public class BeanConfig {

    private final EmailNotification emailNotification;
    private final SmsNotification smsNotification;
    private final Map<String, NotificationService> allNotificationServices;

    BeanConfig(EmailNotification emailNotification, SmsNotification smsNotification, Map<String, NotificationService> allNotificationServices) {
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
        this.allNotificationServices = allNotificationServices;
    }

    @Bean
    @Scope("singleton")
    // This holds priority over @Component annotation in PaymentService class
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public NotificationService notificationService(@Qualifier("smsNotification") NotificationService notificationService) {
        return notificationService;
    }
}
