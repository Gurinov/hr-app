package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.FeedbackDao;
import com.gurinov.hrapp.dto.FeedbackDto;
import com.gurinov.hrapp.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class FeedbackService implements EntityService<Feedback, FeedbackDto> {

    private final FeedbackDao feedbackDao;

    public FeedbackService(final FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @Override
    public List<FeedbackDto> findAll() {
        ArrayList<FeedbackDto> feedbacks = new ArrayList<>();
        for (Feedback feedback : feedbackDao.findAll()) {
            feedbacks.add(new FeedbackDto(feedback));
        }
        return feedbacks;
    }

    @Override
    public FeedbackDto findById(final int id) {
        return new FeedbackDto(feedbackDao.getOne(id));
    }

    @Override
    public void create(final Feedback obj) {
        feedbackDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        feedbackDao.deleteById(id);
    }

    @Override
    public FeedbackDto update(final Feedback obj) {
        return new FeedbackDto(feedbackDao.saveAndFlush(obj));
    }
}
