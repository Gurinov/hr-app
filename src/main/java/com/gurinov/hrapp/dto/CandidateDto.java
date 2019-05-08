package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.enums.State;
import com.gurinov.hrapp.model.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class CandidateDto {
    private Integer id;
    private List<SkillDto> skills;
    private List<ContactDetailsDto> contacts;
    private List<CandidateExperienceDto> experiences;
    private List<AttachmentDto> attachments;
    private String name;
    private String surname;
    private Date birthday;
    private Integer salary;
    private State state;

    public CandidateDto(final Candidate candidate) {
        skills = new ArrayList<>();
        contacts = new ArrayList<>();
        experiences = new ArrayList<>();
        attachments = new ArrayList<>();
        id = candidate.getId();
        for (Skill skill : candidate.getSkills()) {
            this.skills.add(new SkillDto(skill));
        }
        for (ContactDetails contactDetails : candidate.getContacts()) {
            this.contacts.add(new ContactDetailsDto(contactDetails));
        }
        for (CandidateExperience candidateExperience : candidate.getExperiences()) {
            this.experiences.add(new CandidateExperienceDto(candidateExperience));
        }
        for (Attachment attachment : candidate.getAttachments()) {
            this.attachments.add(new AttachmentDto(attachment));
        }
        name = candidate.getName();
        surname = candidate.getSurname();
        birthday = candidate.getBirthday();
        salary = candidate.getSalary();
        state = candidate.getState();
    }
}
