package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.RoleDto;
import com.gurinov.hrapp.model.Role;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 36000000)
@RestController
@RequestMapping(path = "/role")
public class RoleController {

    private final EntityService<Role, RoleDto> roleService;

    public RoleController(final EntityService<Role, RoleDto> roleService) {
        this.roleService = roleService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "")
    public @ResponseBody
    List<RoleDto> findAll() {
        return roleService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody RoleDto findById(@PathVariable final Integer id) {
        return roleService.findById(id);
    }

    @PostMapping(path = "/create/**")
    public void create(@RequestBody final Role role) {
        roleService.create(role);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        roleService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public RoleDto update(@RequestBody final Role role) {
        return roleService.update(role);
    }
}
