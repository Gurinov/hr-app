package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
