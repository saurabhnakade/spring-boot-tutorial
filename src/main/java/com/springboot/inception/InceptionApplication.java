package com.springboot.inception;

import com.springboot.inception.assignments.module1.CakeBaker;
import com.springboot.inception.notification.NotificationService;
import com.springboot.inception.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class InceptionApplication implements CommandLineRunner {

	private final PaymentService paymentService;
	private final NotificationService notificationService;
	private final CakeBaker cakeBaker;

	public static void main(String[] args) {
		SpringApplication.run(InceptionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		paymentService.pay();

		notificationService.sendNotification();

		// Module 1 Assignment: Bake a cake with the configured frosting and syrup
		cakeBaker.bakeCake();
	}
}
