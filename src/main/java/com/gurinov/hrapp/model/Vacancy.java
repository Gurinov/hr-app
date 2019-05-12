package com.gurinov.hrapp.model;

import com.gurinov.hrapp.enums.State;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Skill> skills;

    @Size(min = 2, max = 30)
    private String position;

    @NotNull
    @Min(0)
    @Max(20000)
    private Integer salary;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer experience;

    @Enumerated(EnumType.STRING)
    private State state;
}
