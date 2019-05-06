package com.gurinov.hrapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "interviewer_id")
    private Interviewer interviewer;

    private String result;
    private String feedback;
}
