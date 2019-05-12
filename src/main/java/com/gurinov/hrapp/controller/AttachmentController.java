package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.AttachmentDto;
import com.gurinov.hrapp.model.Attachment;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/attachment")
public final class AttachmentController {

    private final EntityService<Attachment, AttachmentDto> attachmentService;

    public AttachmentController(final EntityService<Attachment, AttachmentDto> attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<AttachmentDto> findAll() {
        return attachmentService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody AttachmentDto findById(@PathVariable final Integer id) {
        return attachmentService.findById(id);
    }

    @PostMapping(path = "/create/**")
    public void create(@RequestBody final Attachment attachment) {
        attachmentService.create(attachment);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        attachmentService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public AttachmentDto update(@RequestBody final Attachment attachment) {
        return attachmentService.update(attachment);
    }
}
