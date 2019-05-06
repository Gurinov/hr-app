package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Responsibility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsibilityDao extends JpaRepository<Responsibility, Integer> {
}
