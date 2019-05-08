package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.AttachmentDao;
import com.gurinov.hrapp.dto.AttachmentDto;
import com.gurinov.hrapp.model.Attachment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class AttachmentService implements EntityService<Attachment, AttachmentDto> {

    private final AttachmentDao attachmentDao;

    public AttachmentService(final AttachmentDao attachmentDao) {
        this.attachmentDao = attachmentDao;
    }

    @Override
    public List<AttachmentDto> findAll() {
        ArrayList<AttachmentDto> attachments = new ArrayList<>();
        for (Attachment attachment : attachmentDao.findAll()) {
            attachments.add(new AttachmentDto(attachment));
        }
        return attachments;
    }

    @Override
    public AttachmentDto findById(final int id) {
        return new AttachmentDto(attachmentDao.getOne(id));
    }

    @Override
    public void create(final Attachment obj) {
        attachmentDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        attachmentDao.deleteById(id);
    }

    @Override
    public AttachmentDto update(final Attachment obj) {
        return new AttachmentDto(attachmentDao.saveAndFlush(obj));
    }
}
