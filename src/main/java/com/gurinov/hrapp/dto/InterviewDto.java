package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.model.Interview;
import com.gurinov.hrapp.model.Interviewer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InterviewDto {
    private Integer id;
    private CandidateDto candidate;
    private VacancyDto vacancy;
    private FeedbackDto feedback;
    private List<UserDto> interviewers;

    public InterviewDto(final Interview interview) {
        interviewers = new ArrayList<>();
        id = interview.getId();
        candidate = new CandidateDto(interview.getCandidate());
        vacancy = new VacancyDto(interview.getVacancy());
        feedback = new FeedbackDto(interview.getFeedback());
        for (Interviewer interviewer : interview.getInterviewers()) {
            this.interviewers.add(new UserDto(interviewer.getUser()));
        }
    }
}
