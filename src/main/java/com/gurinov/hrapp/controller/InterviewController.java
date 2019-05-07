package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.InterviewDao;
import com.gurinov.hrapp.model.Interview;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/interview")
public final class InterviewController {

    private final InterviewDao interviewDao;

    public InterviewController(final InterviewDao interviewDao) {
        this.interviewDao = interviewDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Interview> getAll() {
        return interviewDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody Interview getById(@PathVariable final Integer id) {
        return interviewDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<Interview> addNew(@RequestBody final Interview interview) {
        interviewDao.save(interview);
        return interviewDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        interviewDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Interview interview) {
        interviewDao.saveAndFlush(interview);
    }
}
