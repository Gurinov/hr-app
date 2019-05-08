package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.model.Skill;
import lombok.Data;

@Data
public class SkillDto {
    private Integer id;
    private String skill;

    public SkillDto(final Skill skill) {
        id = skill.getId();
        this.skill = skill.getSkill();
    }
}
