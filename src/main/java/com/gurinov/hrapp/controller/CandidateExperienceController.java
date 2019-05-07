package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.CandidateExperienceDao;
import com.gurinov.hrapp.model.CandidateExperience;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/candidate_experience")
public final class CandidateExperienceController {

    private final CandidateExperienceDao candidateExperienceDao;

    public CandidateExperienceController(final CandidateExperienceDao candidateExperienceDao) {
        this.candidateExperienceDao = candidateExperienceDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<CandidateExperience> getAll() {
        return candidateExperienceDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody CandidateExperience getById(@PathVariable final Integer id) {
        return candidateExperienceDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<CandidateExperience> addNew(@RequestBody final CandidateExperience candidateExperience) {
        candidateExperienceDao.save(candidateExperience);
        return candidateExperienceDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        candidateExperienceDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final CandidateExperience candidateExperience) {
        candidateExperienceDao.saveAndFlush(candidateExperience);
    }
}