package com.springboot.inception.notification.impl;

import com.springboot.inception.notification.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailNotification")
@ConditionalOnProperty(name = "notification.email", havingValue = "true")
public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("Sending email notification...");
    }
}
