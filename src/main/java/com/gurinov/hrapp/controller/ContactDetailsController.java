package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.ContactDetailsDao;
import com.gurinov.hrapp.model.ContactDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contact_details")
public final class ContactDetailsController {

    private final ContactDetailsDao contactDetailsDao;

    public ContactDetailsController(final ContactDetailsDao contactDetailsDao) {
        this.contactDetailsDao = contactDetailsDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<ContactDetails> getAll() {
        return contactDetailsDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody ContactDetails getById(@PathVariable final Integer id) {
        return contactDetailsDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<ContactDetails> addNew(@RequestBody final ContactDetails contactDetails) {
        contactDetailsDao.save(contactDetails);
        return contactDetailsDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        contactDetailsDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final ContactDetails contactDetails) {
        contactDetailsDao.saveAndFlush(contactDetails);
    }
}