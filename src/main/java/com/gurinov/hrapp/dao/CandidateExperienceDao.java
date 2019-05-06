package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.CandidateExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer> {
}
