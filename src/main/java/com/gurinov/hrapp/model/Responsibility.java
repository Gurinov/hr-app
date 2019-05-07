package com.gurinov.hrapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Responsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "responsibility")
    private Set<CandidateExperience> experience;

    private String responsibility;
}
