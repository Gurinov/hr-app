package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.VacancyDto;
import com.gurinov.hrapp.model.Vacancy;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 36000000)
@RestController
@RequestMapping(path = "/vacancy")
public final class VacancyController {

    private final EntityService<Vacancy, VacancyDto> vacancyService;

    public VacancyController(final EntityService<Vacancy, VacancyDto> vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<VacancyDto> findAll() {
        return vacancyService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody VacancyDto findById(@PathVariable final Integer id) {
        return vacancyService.findById(id);
    }

    @PostMapping(path = "/create/**")
    public void create(@RequestBody final Vacancy vacancy) {
        vacancyService.create(vacancy);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        vacancyService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public VacancyDto update(@RequestBody final Vacancy vacancy) {
        return vacancyService.update(vacancy);
    }
}
