package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.VacancyDao;
import com.gurinov.hrapp.dto.VacancyDto;
import com.gurinov.hrapp.model.Vacancy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class VacancyService implements EntityService<Vacancy, VacancyDto> {

    private final VacancyDao vacancyDao;

    public VacancyService(final VacancyDao vacancyDao) {
        this.vacancyDao = vacancyDao;
    }

    @Override
    public List<VacancyDto> findAll() {
        ArrayList<VacancyDto> vacancys = new ArrayList<>();
        for (Vacancy vacancy : vacancyDao.findAll()) {
            vacancys.add(new VacancyDto(vacancy));
        }
        return vacancys;
    }

    @Override
    public VacancyDto findById(final int id) {
        return new VacancyDto(vacancyDao.getOne(id));
    }

    @Override
    public void create(final Vacancy obj) {
        vacancyDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        vacancyDao.deleteById(id);
    }

    @Override
    public VacancyDto update(final Vacancy obj) {
        return new VacancyDto(vacancyDao.saveAndFlush(obj));
    }
}
