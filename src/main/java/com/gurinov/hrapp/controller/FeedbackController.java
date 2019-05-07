package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.FeedbackDao;
import com.gurinov.hrapp.model.Feedback;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/feedback")
public final class FeedbackController {

    private final FeedbackDao feedbackDao;

    public FeedbackController(final FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Feedback> getAll() {
        return feedbackDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody
    Feedback getById(@PathVariable final Integer id) {
        return feedbackDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody
    List<Feedback> addNew(@RequestBody final Feedback feedback) {
        feedbackDao.save(feedback);
        return feedbackDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        feedbackDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Feedback feedback) {
        feedbackDao.saveAndFlush(feedback);
    }
}
