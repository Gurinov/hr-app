package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyDao extends JpaRepository<Vacancy, Integer> {
}
