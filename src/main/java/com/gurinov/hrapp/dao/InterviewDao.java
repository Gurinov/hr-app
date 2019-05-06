package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewDao extends JpaRepository<Interview, Integer> {
}
