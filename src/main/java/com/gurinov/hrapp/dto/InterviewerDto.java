package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.model.Interview;
import com.gurinov.hrapp.model.Interviewer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InterviewerDto {
    private Integer id;
    private List<InterviewDto> interviews;
    private UserDto user;

    public InterviewerDto(final Interviewer interviewer) {
        interviews = new ArrayList<>();
        id = interviewer.getId();
        for (Interview interview : interviewer.getInterviews()) {
            this.interviews.add(new InterviewDto(interview));
        }
        user = new UserDto(interviewer.getUser());
    }
}
