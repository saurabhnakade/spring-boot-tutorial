package com.springboot.inception.notification.impl;

import com.springboot.inception.notification.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsNotification")
@ConditionalOnProperty(name = "notification.sms", havingValue = "true")
public class SmsNotification implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("Sending SMS notification...");
    }
}
