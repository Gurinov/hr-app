package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.CandidateExperienceDao;
import com.gurinov.hrapp.dto.CandidateExperienceDto;
import com.gurinov.hrapp.model.CandidateExperience;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class CandidateExperienceService implements EntityService<CandidateExperience, CandidateExperienceDto> {

    private final CandidateExperienceDao candidateExperienceDao;

    public CandidateExperienceService(final CandidateExperienceDao candidateExperienceDao) {
        this.candidateExperienceDao = candidateExperienceDao;
    }

    @Override
    public List<CandidateExperienceDto> findAll() {
        ArrayList<CandidateExperienceDto> candidateExperiences = new ArrayList<>();
        for (CandidateExperience candidateExperience : candidateExperienceDao.findAll()) {
            candidateExperiences.add(new CandidateExperienceDto(candidateExperience));
        }
        return candidateExperiences;
    }

    @Override
    public CandidateExperienceDto findById(final int id) {
        return new CandidateExperienceDto(candidateExperienceDao.getOne(id));
    }

    @Override
    public void create(final CandidateExperience obj) {
        candidateExperienceDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        candidateExperienceDao.deleteById(id);
    }

    @Override
    public CandidateExperienceDto update(final CandidateExperience obj) {
        return new CandidateExperienceDto(candidateExperienceDao.saveAndFlush(obj));
    }
}
