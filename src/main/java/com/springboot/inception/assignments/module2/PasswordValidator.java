package com.springboot.inception.assignments.module2;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordAnnotation, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");
        boolean hasMinLength = password.length() >= 10;

        return hasUpperCase
                && hasLowerCase
                && hasSpecialChar
                && hasMinLength;
    }
}
