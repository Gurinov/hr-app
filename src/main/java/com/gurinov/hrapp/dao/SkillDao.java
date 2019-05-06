package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository<Skill, Integer> {
}
