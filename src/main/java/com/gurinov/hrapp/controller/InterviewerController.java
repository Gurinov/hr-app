package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.InterviewerDao;
import com.gurinov.hrapp.model.Interviewer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/interviewer")
public final class InterviewerController {

    private final InterviewerDao interviewerDao;

    public InterviewerController(final InterviewerDao interviewerDao) {
        this.interviewerDao = interviewerDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Interviewer> getAll() {
        return interviewerDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody Interviewer getById(@PathVariable final Integer id) {
        return interviewerDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<Interviewer> addNew(@RequestBody final Interviewer interviewer) {
        interviewerDao.save(interviewer);
        return interviewerDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        interviewerDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Interviewer interviewer) {
        interviewerDao.saveAndFlush(interviewer);
    }
}
