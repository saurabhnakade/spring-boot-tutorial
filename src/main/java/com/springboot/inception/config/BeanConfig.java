package com.springboot.inception.config;

import com.springboot.inception.auth.AuditorAwareImpl;
import com.springboot.inception.notification.NotificationService;
import com.springboot.inception.notification.impl.EmailNotification;
import com.springboot.inception.notification.impl.SmsNotification;
import com.springboot.inception.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableJpaAuditing(auditorAwareRef = "getAuditorAware")
public class BeanConfig {

    private final EmailNotification emailNotification;
    private final SmsNotification smsNotification;
    private final Map<String, NotificationService> allNotificationServices;

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

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public AuditorAware<String> getAuditorAware() {
        return new AuditorAwareImpl();
    }
}
