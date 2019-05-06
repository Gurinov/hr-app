package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
}
