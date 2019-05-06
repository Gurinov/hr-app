package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
