package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.InterviewerDao;
import com.gurinov.hrapp.dto.InterviewerDto;
import com.gurinov.hrapp.model.Interviewer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class InterviewerService implements EntityService<Interviewer, InterviewerDto> {

    private final InterviewerDao interviewerDao;

    public InterviewerService(final InterviewerDao interviewerDao) {
        this.interviewerDao = interviewerDao;
    }

    @Override
    public List<InterviewerDto> findAll() {
        ArrayList<InterviewerDto> interviewers = new ArrayList<>();
        for (Interviewer interviewer : interviewerDao.findAll()) {
            interviewers.add(new InterviewerDto(interviewer));
        }
        return interviewers;
    }

    @Override
    public InterviewerDto findById(final int id) {
        return new InterviewerDto(interviewerDao.getOne(id));
    }

    @Override
    public void create(final Interviewer obj) {
        interviewerDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        interviewerDao.deleteById(id);
    }

    @Override
    public InterviewerDto update(final Interviewer obj) {
        return new InterviewerDto(interviewerDao.saveAndFlush(obj));
    }
}
