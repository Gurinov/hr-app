package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.UserDao;
import com.gurinov.hrapp.dto.UserDto;
import com.gurinov.hrapp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class UserService implements EntityService<User, UserDto> {

    private final UserDao userDao;

    public UserService(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDto> findAll() {
        ArrayList<UserDto> users = new ArrayList<>();
        for (User user : userDao.findAll()) {
            users.add(new UserDto(user));
        }
        return users;
    }

    @Override
    public UserDto findById(final int id) {
        return new UserDto(userDao.getOne(id));
    }

    @Override
    public void create(final User obj) {
        userDao.save(obj);
    }

    @Override
    public void delete(final int id) {
        userDao.deleteById(id);
    }

    @Override
    public UserDto update(final User obj) {
        return new UserDto(userDao.saveAndFlush(obj));
    }
}
