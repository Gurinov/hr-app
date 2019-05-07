package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.SkillDao;
import com.gurinov.hrapp.model.Skill;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/skill")
public final class SkillController {

    private final SkillDao skillDao;

    public SkillController(final SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Skill> getAll() {
        return skillDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody Skill getById(@PathVariable final Integer id) {
        return skillDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<Skill> addNew(@RequestBody final Skill skill) {
        skillDao.save(skill);
        return skillDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        skillDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Skill skill) {
        skillDao.saveAndFlush(skill);
    }
}