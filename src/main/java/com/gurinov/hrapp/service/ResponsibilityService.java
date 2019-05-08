package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.ResponsibilityDao;
import com.gurinov.hrapp.dto.ResponsibilityDto;
import com.gurinov.hrapp.model.Responsibility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class ResponsibilityService implements EntityService<Responsibility, ResponsibilityDto> {

    private final ResponsibilityDao responsibilityDao;

    public ResponsibilityService(final ResponsibilityDao responsibilityDao) {
        this.responsibilityDao = responsibilityDao;
    }

    @Override
    public List<ResponsibilityDto> findAll() {
        ArrayList<ResponsibilityDto> responsibilitys = new ArrayList<>();
        for (Responsibility responsibility : responsibilityDao.findAll()) {
            responsibilitys.add(new ResponsibilityDto(responsibility));
        }
        return responsibilitys;
    }

    @Override
    public ResponsibilityDto findById(final int id) {
        return new ResponsibilityDto(responsibilityDao.getOne(id));
    }

    @Override
    public void create(final Responsibility obj) {
        responsibilityDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        responsibilityDao.deleteById(id);
    }

    @Override
    public ResponsibilityDto update(final Responsibility obj) {
        return new ResponsibilityDto(responsibilityDao.saveAndFlush(obj));
    }
}
