package com.gurinov.hrapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
public class Responsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "responsibility")
    private Set<CandidateExperience> experience;

    @Size(min = 2, max = 30)
    private String responsibility;
}
