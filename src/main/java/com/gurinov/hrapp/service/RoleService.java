package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.RoleDao;
import com.gurinov.hrapp.dto.RoleDto;
import com.gurinov.hrapp.model.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class RoleService implements EntityService<Role, RoleDto> {

    private final RoleDao roleDao;

    public RoleService(final RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<RoleDto> findAll() {
        ArrayList<RoleDto> roles = new ArrayList<>();
        for (Role role : roleDao.findAll()) {
            roles.add(new RoleDto(role));
        }
        return roles;
    }

    @Override
    public RoleDto findById(final int id) {
        return new RoleDto(roleDao.getOne(id));
    }

    @Override
    public void create(final Role obj) {
        roleDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        roleDao.deleteById(id);
    }

    @Override
    public RoleDto update(final Role obj) {
        return new RoleDto(roleDao.saveAndFlush(obj));
    }
}
