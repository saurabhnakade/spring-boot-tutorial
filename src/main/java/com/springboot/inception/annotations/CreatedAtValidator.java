package com.springboot.inception.annotations;

import jakarta.validation.ConstraintValidator;

public class CreatedAtValidator implements ConstraintValidator<CreatedAtValidation, Object> {

    @Override
    public boolean isValid(Object value, jakarta.validation.ConstraintValidatorContext context) {
        return value == null;
    }
}
