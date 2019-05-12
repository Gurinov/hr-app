package com.gurinov.hrapp.model;

import com.gurinov.hrapp.enums.State;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ContactDetails> contacts;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CandidateExperience> experiences;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Attachment> attachments;

    @Size(min = 2, max = 30)
    private String name;

    @Size(min = 2, max = 30)
    private String surname;

    @Past
    private Date birthday;

    @NotNull
    @Min(50)
    @Max(20000)
    private Integer salary;

    @Enumerated(EnumType.STRING)
    private State state;
}
