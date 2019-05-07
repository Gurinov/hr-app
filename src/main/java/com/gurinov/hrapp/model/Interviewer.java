package com.gurinov.hrapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "interviews")
public class Interviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "interviewer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "interview_id", referencedColumnName = "id")
    )
    private Set<Interview> interviews;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
