package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.ResponsibilityDao;
import com.gurinov.hrapp.model.Responsibility;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/responsibility")
public final class ResponsibilityController {

    private final ResponsibilityDao responsibilityDao;

    public ResponsibilityController(final ResponsibilityDao responsibilityDao) {
        this.responsibilityDao = responsibilityDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Responsibility> getAll() {
        return responsibilityDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody Responsibility getById(@PathVariable final Integer id) {
        return responsibilityDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<Responsibility> addNew(@RequestBody final Responsibility responsibility) {
        responsibilityDao.save(responsibility);
        return responsibilityDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        responsibilityDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Responsibility responsibility) {
        responsibilityDao.saveAndFlush(responsibility);
    }
}
