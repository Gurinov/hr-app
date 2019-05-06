package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailsDao extends JpaRepository<ContactDetails, Integer> {
}
