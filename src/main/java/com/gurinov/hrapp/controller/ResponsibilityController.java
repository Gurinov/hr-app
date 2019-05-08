package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.ResponsibilityDto;
import com.gurinov.hrapp.model.Responsibility;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/responsibility")
public final class ResponsibilityController {

    private final EntityService<Responsibility, ResponsibilityDto> responsibilityService;

    public ResponsibilityController(final EntityService<Responsibility, ResponsibilityDto> responsibilityService) {
        this.responsibilityService = responsibilityService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<ResponsibilityDto> findAll() {
        return responsibilityService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody ResponsibilityDto findById(@PathVariable final Integer id) {
        return responsibilityService.findById(id);
    }

    @PostMapping(path = "/add/**")
    public void create(@RequestBody final Responsibility responsibility) {
        responsibilityService.create(responsibility);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        responsibilityService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public ResponsibilityDto update(@RequestBody final Responsibility responsibility) {
        return responsibilityService.update(responsibility);
    }
}
