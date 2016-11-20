package com.lvg.txtest.valid;

import com.lvg.txtest.conv.models.User;
import com.lvg.txtest.valid.services.UserValidationService;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Victor Levchenko (LVG Corp.) on 19.11.2016.
 */
public class Jsr349Test {

    private static final Logger LOG = Logger.getLogger(ValidatorTest.class);

    public static void main(String[] args) {
        LOG.info("START JSR349 VALIDATOR TEST MODULE");
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:META-INF/spring/jsr349-valid-app-context.xml");

        UserValidationService contactValidationService =
                ctx.getBean("userValidationService", UserValidationService.class);

        User user = new User();
        user.setFirstName("MAr");
        user.setLastName("Gir");
        user.setBirthDate(null);

        validateUser(user, contactValidationService);

        LOG.info("END JSR349 VALIDATOR TEST MODULE");
    }

    private static void validateUser(User user, UserValidationService validationService){
        Set<ConstraintViolation<User>> violations =
                new HashSet<>();
        violations = validationService.validateUser(user);
        listViolations(violations);
    }


    private static void listViolations(Set<ConstraintViolation<User>> violations){
        System.out.println("No. of violations: "+ violations.size());
        for (ConstraintViolation<User> vc : violations){
            System.out.println("Validation error for property: "+
                    vc.getPropertyPath()
                + " with value: "+ vc.getInvalidValue()
                + " with error message: "+ vc.getMessage());
        }
    }
}
