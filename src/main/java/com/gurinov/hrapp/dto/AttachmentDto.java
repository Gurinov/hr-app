package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.enums.AttachmentType;
import com.gurinov.hrapp.model.Attachment;
import lombok.Data;

@Data
public class AttachmentDto {
    private Integer id;
    private String path;
    private String name;
    private AttachmentType type;

    public AttachmentDto(final Attachment attachment) {
        id = attachment.getId();
        path = attachment.getPath();
        name = attachment.getName();
        type = attachment.getType();
    }
}
