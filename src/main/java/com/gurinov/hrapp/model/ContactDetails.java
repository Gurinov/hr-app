package com.gurinov.hrapp.model;

import com.gurinov.hrapp.enums.ContactType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    private String contactDetails;
}
