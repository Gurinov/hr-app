package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.ContactDetailsDao;
import com.gurinov.hrapp.dto.ContactDetailsDto;
import com.gurinov.hrapp.model.ContactDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class ContactDetailsService implements EntityService<ContactDetails, ContactDetailsDto> {

    private final ContactDetailsDao contactDetailsDao;

    public ContactDetailsService(final ContactDetailsDao contactDetailsDao) {
        this.contactDetailsDao = contactDetailsDao;
    }

    @Override
    public List<ContactDetailsDto> findAll() {
        ArrayList<ContactDetailsDto> contactDetailss = new ArrayList<>();
        for (ContactDetails contactDetails : contactDetailsDao.findAll()) {
            contactDetailss.add(new ContactDetailsDto(contactDetails));
        }
        return contactDetailss;
    }

    @Override
    public ContactDetailsDto findById(final int id) {
        return new ContactDetailsDto(contactDetailsDao.getOne(id));
    }

    @Override
    public void create(final ContactDetails obj) {
        contactDetailsDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        contactDetailsDao.deleteById(id);
    }

    @Override
    public ContactDetailsDto update(final ContactDetails obj) {
        return new ContactDetailsDto(contactDetailsDao.saveAndFlush(obj));
    }
}
