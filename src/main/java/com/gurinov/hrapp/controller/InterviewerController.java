package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.InterviewerDto;
import com.gurinov.hrapp.model.Interviewer;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/interviewer")
public final class InterviewerController {

    private final EntityService<Interviewer, InterviewerDto> interviewerService;

    public InterviewerController(final EntityService<Interviewer, InterviewerDto> interviewerService) {
        this.interviewerService = interviewerService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<InterviewerDto> findAll() {
        return interviewerService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody InterviewerDto findById(@PathVariable final Integer id) {
        return interviewerService.findById(id);
    }

    @PostMapping(path = "/create/**")
    public void create(@RequestBody final Interviewer interviewer) {
        interviewerService.create(interviewer);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        interviewerService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public InterviewerDto update(@RequestBody final Interviewer interviewer) {
        return interviewerService.update(interviewer);
    }
}
