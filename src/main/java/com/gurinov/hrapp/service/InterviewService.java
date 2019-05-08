package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.InterviewDao;
import com.gurinov.hrapp.dto.InterviewDto;
import com.gurinov.hrapp.model.Interview;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class InterviewService implements EntityService<Interview, InterviewDto> {

    private final InterviewDao interviewDao;

    public InterviewService(final InterviewDao interviewDao) {
        this.interviewDao = interviewDao;
    }

    @Override
    public List<InterviewDto> findAll() {
        ArrayList<InterviewDto> interviews = new ArrayList<>();
        for (Interview interview : interviewDao.findAll()) {
            interviews.add(new InterviewDto(interview));
        }
        return interviews;
    }

    @Override
    public InterviewDto findById(final int id) {
        return new InterviewDto(interviewDao.getOne(id));
    }

    @Override
    public void create(final Interview obj) {
        interviewDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        interviewDao.deleteById(id);
    }

    @Override
    public InterviewDto update(final Interview obj) {
        return new InterviewDto(interviewDao.saveAndFlush(obj));
    }
}
