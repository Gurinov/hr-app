package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.AttachmentDao;
import com.gurinov.hrapp.model.Attachment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/attachment")
public final class AttachmentController {

    private final AttachmentDao attachmentDao;

    public AttachmentController(final AttachmentDao attachmentDao) {
        this.attachmentDao = attachmentDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Attachment> getAll() {
        return attachmentDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody
    Attachment getById(@PathVariable final Integer id) {
        return attachmentDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody
    List<Attachment> addNew(@RequestBody final Attachment attachment) {
        attachmentDao.save(attachment);
        return attachmentDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        attachmentDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Attachment attachment) {
        attachmentDao.saveAndFlush(attachment);
    }
}
