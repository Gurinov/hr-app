package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.CandidateExperienceDto;
import com.gurinov.hrapp.model.CandidateExperience;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/candidateExperience")
public final class CandidateExperienceController {

    private final EntityService<CandidateExperience, CandidateExperienceDto> candidateExperienceService;

    public CandidateExperienceController(
            final EntityService<CandidateExperience, CandidateExperienceDto> candidateExperienceService
    ) {
        this.candidateExperienceService = candidateExperienceService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<CandidateExperienceDto> findAll() {
        return candidateExperienceService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody CandidateExperienceDto findById(@PathVariable final Integer id) {
        return candidateExperienceService.findById(id);
    }

    @PostMapping(path = "/add/**")
    public void create(@RequestBody final CandidateExperience candidateExperience) {
        candidateExperienceService.create(candidateExperience);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        candidateExperienceService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public CandidateExperienceDto update(@RequestBody final CandidateExperience candidateExperience) {
        return candidateExperienceService.update(candidateExperience);
    }
}
