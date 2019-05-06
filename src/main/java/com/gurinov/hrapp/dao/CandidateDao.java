package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
}
