package com.example.assignment.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class SalaryValidatorImpl implements
        ConstraintValidator<SalaryValidator, Long> {

    @Override
    public void initialize(SalaryValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        return aLong > 0;
    }
}
