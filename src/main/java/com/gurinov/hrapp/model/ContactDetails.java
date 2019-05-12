package com.gurinov.hrapp.model;

import com.gurinov.hrapp.enums.ContactType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@EqualsAndHashCode(exclude = "candidate")
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    @Size(min = 5, max = 50)
    private String contactDetails;
}
