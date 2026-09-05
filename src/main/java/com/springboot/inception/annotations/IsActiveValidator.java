package com.springboot.inception.annotations;

import jakarta.validation.ConstraintValidator;

public class IsActiveValidator implements ConstraintValidator<IsActiveValidation, Boolean> {

    @Override
    public boolean isValid(Boolean value, jakarta.validation.ConstraintValidatorContext context) {
        return value == true || value == false;
    }
}
