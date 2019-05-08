package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.SkillDao;
import com.gurinov.hrapp.dto.SkillDto;
import com.gurinov.hrapp.model.Skill;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class SkillService implements EntityService<Skill, SkillDto> {

    private final SkillDao skillDao;

    public SkillService(final SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public List<SkillDto> findAll() {
        ArrayList<SkillDto> skills = new ArrayList<>();
        for (Skill skill : skillDao.findAll()) {
            skills.add(new SkillDto(skill));
        }
        return skills;
    }

    @Override
    public SkillDto findById(final int id) {
        return new SkillDto(skillDao.getOne(id));
    }

    @Override
    public void create(final Skill obj) {
        skillDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        skillDao.deleteById(id);
    }

    @Override
    public SkillDto update(final Skill obj) {
        return new SkillDto(skillDao.saveAndFlush(obj));
    }
}
