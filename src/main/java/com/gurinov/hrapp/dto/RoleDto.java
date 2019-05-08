package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.model.Role;
import lombok.Data;

@Data
public class RoleDto {
    private Integer id;
    private String name;

    public RoleDto(final Role role) {
        id = role.getId();
        name = role.getName();
    }
}
