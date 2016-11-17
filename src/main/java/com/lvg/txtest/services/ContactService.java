package com.lvg.txtest.services;

import com.lvg.txtest.models.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Victor on 17.11.2016.
 */
public interface ContactService {

    List<Contact> findAll();
    Contact save(Contact contact);
    Contact findById(Long id);
    long countAll();

}
