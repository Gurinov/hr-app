package com.gurinov.hrapp.model;

import com.gurinov.hrapp.enums.AttachmentType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private String path;
    private String name;

    @Enumerated(EnumType.STRING)
    private AttachmentType type;
}
