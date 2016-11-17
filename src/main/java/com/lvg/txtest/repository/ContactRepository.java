package com.lvg.txtest.repository;

import com.lvg.txtest.models.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Victor on 17.11.2016.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query("select count(c) from Contact c")
    Long countAllContact();
}
