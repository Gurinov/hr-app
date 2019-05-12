package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.SkillDto;
import com.gurinov.hrapp.model.Skill;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/skill")
public class SkillController {

    private final EntityService<Skill, SkillDto> skillService;

    public SkillController(final EntityService<Skill, SkillDto> skillService) {
        this.skillService = skillService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "")
    public @ResponseBody List<SkillDto> findAll() {
        return skillService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody SkillDto findById(@PathVariable final Integer id) {
        return skillService.findById(id);
    }

    @PostMapping(path = "/create/**")
    public void create(@RequestBody final Skill skill) {
        skillService.create(skill);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        skillService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public SkillDto update(@RequestBody final Skill skill) {
        return skillService.update(skill);
    }
}
