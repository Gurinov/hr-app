package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.model.CandidateExperience;
import com.gurinov.hrapp.model.Responsibility;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class CandidateExperienceDto {
    private Integer id;
    private List<ResponsibilityDto> responsibility;
    private Date dateFrom;
    private Date dateTo;
    private String jobPosition;
    private String jobDescription;
    private String companyName;

    public CandidateExperienceDto(final CandidateExperience candidateExperience) {
        responsibility = new ArrayList<>();
        id = candidateExperience.getId();
        for (Responsibility responsibility : candidateExperience.getResponsibility()) {
            this.responsibility.add(new ResponsibilityDto(responsibility));
        }
        dateFrom = candidateExperience.getDateFrom();
        dateTo = candidateExperience.getDateTo();
        jobPosition = candidateExperience.getJobPosition();
        jobDescription = candidateExperience.getJobDescription();
        companyName = candidateExperience.getCompanyName();
    }
}
