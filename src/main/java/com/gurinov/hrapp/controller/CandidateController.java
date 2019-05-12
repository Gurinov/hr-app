package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.CandidateDto;
import com.gurinov.hrapp.model.Candidate;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/candidate")
public final class CandidateController {

    private final EntityService<Candidate, CandidateDto> candidateService;

    public CandidateController(final EntityService<Candidate, CandidateDto> candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<CandidateDto> findAll() {
        return candidateService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody CandidateDto findById(@PathVariable final Integer id) {
        return candidateService.findById(id);
    }

    @PostMapping(path = "/create/**")
    public void create(@RequestBody final Candidate candidate) {
        candidateService.create(candidate);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        candidateService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public CandidateDto update(@RequestBody final Candidate candidate) {
        return candidateService.update(candidate);
    }
}
