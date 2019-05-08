package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.enums.ContactType;
import com.gurinov.hrapp.model.ContactDetails;
import lombok.Data;

@Data
public class ContactDetailsDto {
    private Integer id;
    private ContactType type;
    private String contactDetails;

    public ContactDetailsDto(final ContactDetails contactDetails) {
        id = contactDetails.getId();
        type = contactDetails.getType();
        this.contactDetails = contactDetails.getContactDetails();
    }
}
