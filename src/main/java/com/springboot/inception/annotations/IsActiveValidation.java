package com.springboot.inception.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {IsActiveValidator.class}
)
public @interface IsActiveValidation {

    String message() default "The value must be true or false";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
