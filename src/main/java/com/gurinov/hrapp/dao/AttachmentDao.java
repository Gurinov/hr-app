package com.gurinov.hrapp.dao;

import com.gurinov.hrapp.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentDao extends JpaRepository<Attachment, Integer> {
}
