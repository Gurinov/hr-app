package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.VacancyDao;
import com.gurinov.hrapp.model.Vacancy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vacancy")
public final class VacancyController {

    private final VacancyDao vacancyDao;

    public VacancyController(final VacancyDao vacancyDao) {
        this.vacancyDao = vacancyDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Vacancy> getAll() {
        return vacancyDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody Vacancy getById(@PathVariable final Integer id) {
        return vacancyDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<Vacancy> addNew(@RequestBody final Vacancy vacancy) {
        vacancyDao.save(vacancy);
        return vacancyDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        vacancyDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Vacancy vacancy) {
        vacancyDao.saveAndFlush(vacancy);
    }
}
