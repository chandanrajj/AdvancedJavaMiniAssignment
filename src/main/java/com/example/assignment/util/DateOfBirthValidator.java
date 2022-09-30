package com.example.assignment.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateOfBirthValidatorImpl.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOfBirthValidator {
    String message() default "The birth date must be greater than or equal to 18.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
