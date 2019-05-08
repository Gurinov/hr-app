package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.CandidateDao;
import com.gurinov.hrapp.dto.CandidateDto;
import com.gurinov.hrapp.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class CandidateService implements EntityService<Candidate, CandidateDto> {

    private final CandidateDao candidateDao;

    public CandidateService(final CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public List<CandidateDto> findAll() {
        ArrayList<CandidateDto> candidates = new ArrayList<>();
        for (Candidate candidate : candidateDao.findAll()) {
            candidates.add(new CandidateDto(candidate));
        }
        return candidates;
    }

    @Override
    public CandidateDto findById(final int id) {
        return new CandidateDto(candidateDao.getOne(id));
    }

    @Override
    public void create(final Candidate obj) {
        candidateDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        candidateDao.deleteById(id);
    }

    @Override
    public CandidateDto update(final Candidate obj) {
        return new CandidateDto(candidateDao.saveAndFlush(obj));
    }
}
