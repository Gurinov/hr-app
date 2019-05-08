package com.gurinov.hrapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude = "candidate")
public class CandidateExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToMany
    @JoinTable(
            name = "responsibility_experience",
            joinColumns = @JoinColumn(name = "experience_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "responsibility_id", referencedColumnName = "id")
    )
    private List<Responsibility> responsibility;

    private Date dateFrom;
    private Date dateTo;
    private String jobPosition;
    private String jobDescription;
    private String companyName;
}
