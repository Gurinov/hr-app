package com.gurinov.hrapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@EqualsAndHashCode(exclude = "interviewer")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "interviewer_id")
    private Interviewer interviewer;

    @Size(min = 2, max = 30)
    private String result;

    @Size(min = 2, max = 2000)
    private String feedback;
}
