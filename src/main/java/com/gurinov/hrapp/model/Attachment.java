package com.gurinov.hrapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gurinov.hrapp.enums.AttachmentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = "candidate")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private String path;
    private String name;

    @Enumerated(EnumType.STRING)
    private AttachmentType type;
}
