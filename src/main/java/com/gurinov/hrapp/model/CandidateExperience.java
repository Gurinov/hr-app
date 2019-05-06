package com.gurinov.hrapp.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class CandidateExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToMany
    private List<Responsibility> responsibility;

    private Date dateFrom;
    private Date dateTo;
    private String jobPosition;
    private String jobDescription;
    private String companyName;
}
