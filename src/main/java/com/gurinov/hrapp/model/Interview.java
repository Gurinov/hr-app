package com.gurinov.hrapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @OneToOne(fetch = FetchType.EAGER)
    private Feedback feedback;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Interviewer> interviewers;
}
