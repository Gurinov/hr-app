package com.gurinov.hrapp.model;

import com.gurinov.hrapp.enums.State;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Skill> skills;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<ContactDetails> contacts;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<CandidateExperience> experiences;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Attachment> attachments;

    private String name;
    private String surname;
    private Date birthday;
    private Integer salary;

    @Enumerated(EnumType.STRING)
    private State state;
}
