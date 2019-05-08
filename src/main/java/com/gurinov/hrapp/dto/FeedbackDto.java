package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.model.Feedback;
import lombok.Data;

@Data
public class FeedbackDto {
    private Integer id;
    private String result;
    private String feedback;

    public FeedbackDto(final Feedback feedback) {
        id = feedback.getId();
        result = feedback.getResult();
        this.feedback = feedback.getFeedback();
    }
}
