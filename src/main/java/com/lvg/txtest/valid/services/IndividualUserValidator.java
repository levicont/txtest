package com.lvg.txtest.valid.services;

import com.lvg.txtest.conv.models.User;
import com.lvg.txtest.valid.annotation.CheckIndividualUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Victor Levchenko (LVG Corp.) on 20.11.2016.
 */
public class IndividualUserValidator implements ConstraintValidator<CheckIndividualUser, User>{

    @Override
    public void initialize(CheckIndividualUser checkIndividualUser) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if(!user.getFirstName().equalsIgnoreCase("Mark"))
            result = false;
        return result;
    }
}
