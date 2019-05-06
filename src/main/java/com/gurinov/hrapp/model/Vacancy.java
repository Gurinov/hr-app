package com.gurinov.hrapp.model;

import com.gurinov.hrapp.enums.State;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Skill> skills;

    private String position;
    private Integer salary;
    private Integer experience;

    @Enumerated(EnumType.STRING)
    private State state;
}
