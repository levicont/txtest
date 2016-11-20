package com.lvg.txtest.valid.services;

import com.lvg.txtest.conv.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Victor Levchenko (LVG Corp.) on 19.11.2016.
 */

@Service("userValidationService")
public class UserValidationService {

    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<User>> validateUser(User user){
        return validator.validate(user);
    }
}
