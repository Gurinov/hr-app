package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.enums.State;
import com.gurinov.hrapp.model.Skill;
import com.gurinov.hrapp.model.Vacancy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VacancyDto {
    private Integer id;
    private List<SkillDto> skills;
    private String position;
    private Integer salary;
    private Integer experience;
    private State state;

    public VacancyDto(final Vacancy vacancy) {
        skills = new ArrayList<>();
        id = vacancy.getId();
        for (Skill skill : vacancy.getSkills()) {
            this.skills.add(new SkillDto(skill));
        }
        position = vacancy.getPosition();
        salary = vacancy.getSalary();
        experience = vacancy.getExperience();
        state = vacancy.getState();
    }
}
