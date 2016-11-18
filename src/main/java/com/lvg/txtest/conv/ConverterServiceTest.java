package com.lvg.txtest.conv;

import com.lvg.txtest.conv.models.User;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Victor on 18.11.2016.
 */
public class ConverterServiceTest {

    private static final Logger LOG = Logger.getLogger(ConverterServiceTest.class);

    public static void main(String[] args) {
        LOG.info("START CONVERTER SERVICE TEST MODULE");
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:META-INF/spring/conv-service-app-context.xml");
        User chrisUser = ctx.getBean("chris", User.class);
        System.out.println(chrisUser);
        User myUser = ctx.getBean("myUser", User.class);
        System.out.println(myUser);



        LOG.info("END CONVERTER SERVICE TEST MODULE");
    }
}
