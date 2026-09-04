package com.springboot.inception.notification.impl;

import com.springboot.inception.notification.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("Sending SMS notification...");
    }
}
