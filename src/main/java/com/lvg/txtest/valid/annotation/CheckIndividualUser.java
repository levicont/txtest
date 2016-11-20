package com.lvg.txtest.valid.annotation;

import com.lvg.txtest.valid.services.IndividualUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Victor Levchenko (LVG Corp.) on 20.11.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IndividualUserValidator.class)
@Documented
public @interface CheckIndividualUser {
    String message() default "Individual user should have 'Mark' firstName";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
