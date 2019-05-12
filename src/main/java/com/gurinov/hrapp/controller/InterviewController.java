package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.InterviewDto;
import com.gurinov.hrapp.model.Interview;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/interview")
public final class InterviewController {

    private final EntityService<Interview, InterviewDto> interviewService;

    public InterviewController(final EntityService<Interview, InterviewDto> interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<InterviewDto> findAll() {
        return interviewService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody InterviewDto findById(@PathVariable final Integer id) {
        return interviewService.findById(id);
    }

    @PostMapping(path = "/create/**")
    public void create(@RequestBody final Interview interview) {
        interviewService.create(interview);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        interviewService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public InterviewDto update(@RequestBody final Interview interview) {
        return interviewService.update(interview);
    }
}
