package com.lvg.txtest;

import com.lvg.txtest.models.Contact;
import com.lvg.txtest.services.ContactService;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Victor on 17.11.2016.
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        LOG.info("STARTING TEST APPLICATION");

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("META-INF/spring/app-context-jpa.xml");
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        printContacts(contactService.findAll());

        Contact contact = contactService.findById(1L);
        contact.setFirstName("TORRO");
        contact = contactService.save(contact);
        printContact(contact);

        System.out.println("Contact count is "+contactService.countAll());

        LOG.info("END OF TEST APPLICATION");
    }

    private static void printContacts(List<Contact> contacts){
        System.out.println("PRINTING ALL CONTACTS");
        for (Contact c : contacts){
            System.out.println(c);
        }
    }

    private static void printContact(Contact c){
        System.out.println("PRINTING CONTACT");
        System.out.println(c);
    }

    private static Contact getTestContact(){
        Contact newContact = new Contact();
        newContact.setFirstName("Michel");
        newContact.setLastName("Jordan");
        newContact.setBirthDate(new Date());
        return newContact;
    }
}
