package com.lvg.txtest.services.jpa;

import com.google.common.collect.Lists;
import com.lvg.txtest.models.Contact;
import com.lvg.txtest.repository.ContactRepository;
import com.lvg.txtest.services.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Victor on 17.11.2016.
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceJpaImpl implements ContactService {

    private static final Logger LOG = Logger.getLogger(ContactServiceJpaImpl.class);

    @Autowired
    private ContactRepository contactRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional( propagation = Propagation.NEVER)
    public long countAll() {
        return contactRepository.countAllContact();
    }
}
