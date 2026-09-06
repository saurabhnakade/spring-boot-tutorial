package com.springboot.inception.assignments.module2;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {PrimeNoValidator.class}
)
public @interface PrimeNoAnnotation {

    String message() default "The number is not a prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
