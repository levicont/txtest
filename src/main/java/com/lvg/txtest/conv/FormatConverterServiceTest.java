package com.lvg.txtest.conv;

import com.lvg.txtest.conv.models.User;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

/**
 * Created by Victor on 18.11.2016.
 */
public class FormatConverterServiceTest {

    private static final Logger LOG = Logger.getLogger(FormatConverterServiceTest.class);

    public static void main(String[] args) {
        LOG.info("START FORMAT CONVERTER SERVICE TEST MODULE");
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:META-INF/spring/format-conv-service-app-context.xml");

        ConversionService conversionService = ctx.getBean(ConversionService.class);
        User chrisUser = ctx.getBean("chris", User.class);
        System.out.println(chrisUser);
        System.out.println("Formated birth date: "+conversionService.convert(chrisUser.getBirthDate(), String.class));
        User myUser = ctx.getBean("myUser", User.class);
        System.out.println(myUser);
        System.out.println("Formated birth date: "+conversionService.convert(myUser.getBirthDate(), String.class));


        LOG.info("END FORMAT CONVERTER SERVICE TEST MODULE");
    }
}
