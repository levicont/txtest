package com.lvg.txtest.valid;

import com.lvg.txtest.conv.models.User;
import com.lvg.txtest.models.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.validation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Victor on 18.11.2016.
 */
public class ValidatorTest {
    private static final Logger LOG = Logger.getLogger(ValidatorTest.class);

    public static void main(String[] args) {
        LOG.info("START VALIDATOR TEST MODULE");
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:META-INF/spring/valid-app-context.xml");

        Validator validator = ctx.getBean("contactValidator", Validator.class);
        Contact contact = new Contact();
        contact.setFirstName(null);
        contact.setLastName("Gir");
        contact.setBirthDate(new Date());

        BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact,"Chris");
        ValidationUtils.invokeValidator(validator,contact,result);
        List<ObjectError> allErrors = result.getAllErrors();
        for (ObjectError oe : allErrors){
            System.out.println("Error validation: "+oe.getCode());
        }


        LOG.info("END VALIDATOR TEST MODULE");
    }
}
