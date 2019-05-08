package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.ContactDetailsDto;
import com.gurinov.hrapp.model.ContactDetails;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contactDetails")
public final class ContactDetailsController {

    private final EntityService<ContactDetails, ContactDetailsDto> contactDetailsService;

    public ContactDetailsController(final EntityService<ContactDetails, ContactDetailsDto> contactDetailsService) {
        this.contactDetailsService = contactDetailsService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<ContactDetailsDto> findAll() {
        return contactDetailsService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody ContactDetailsDto findById(@PathVariable final Integer id) {
        return contactDetailsService.findById(id);
    }

    @PostMapping(path = "/add/**")
    public void create(@RequestBody final ContactDetails contactDetails) {
        contactDetailsService.create(contactDetails);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        contactDetailsService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public ContactDetailsDto update(@RequestBody final ContactDetails contactDetails) {
        return contactDetailsService.update(contactDetails);
    }
}
