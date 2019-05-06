package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewerDao extends JpaRepository<Interviewer, Integer> {
}
