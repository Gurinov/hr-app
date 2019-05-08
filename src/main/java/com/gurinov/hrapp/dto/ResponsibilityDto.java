package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.model.Responsibility;
import lombok.Data;

@Data
public class ResponsibilityDto {
    private Integer id;
    private String responsibility;

    public ResponsibilityDto(final Responsibility responsibility) {
        id = responsibility.getId();
        this.responsibility = responsibility.getResponsibility();
    }
}
