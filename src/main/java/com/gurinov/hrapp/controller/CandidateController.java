package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.CandidateDao;
import com.gurinov.hrapp.model.Candidate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/сandidate")
public final class CandidateController {

    private final CandidateDao candidateDao;

    public CandidateController(final CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<Candidate> getAll() {
        return candidateDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody Candidate getById(@PathVariable final Integer id) {
        return candidateDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<Candidate> addNew(@RequestBody final Candidate candidate) {
        candidateDao.save(candidate);
        return candidateDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        candidateDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final Candidate candidate) {
        candidateDao.saveAndFlush(candidate);
    }
}
