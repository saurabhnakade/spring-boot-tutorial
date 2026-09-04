package com.springboot.inception;

import com.springboot.inception.notification.NotificationService;
import com.springboot.inception.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InceptionApplication implements CommandLineRunner {

	@Autowired
	PaymentService paymentService;

	@Autowired
	NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(InceptionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		paymentService.pay();

		notificationService.sendNotification();
	}
}
