package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.FeedbackDto;
import com.gurinov.hrapp.model.Feedback;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/feedback")
public final class FeedbackController {

    private final EntityService<Feedback, FeedbackDto> feedbackService;

    public FeedbackController(final EntityService<Feedback, FeedbackDto> feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<FeedbackDto> findAll() {
        return feedbackService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody FeedbackDto findById(@PathVariable final Integer id) {
        return feedbackService.findById(id);
    }

    @PostMapping(path = "/add/**")
    public void create(@RequestBody final Feedback feedback) {
        feedbackService.create(feedback);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        feedbackService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public FeedbackDto update(@RequestBody final Feedback feedback) {
        return feedbackService.update(feedback);
    }
}
