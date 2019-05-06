package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dao.UserDao;
import com.gurinov.hrapp.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public final class UserController {

    private final UserDao userDao;

    public UserController(final UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "")
    public @ResponseBody List<User> getAll() {
        return userDao.findAll();
    }

    @GetMapping(path = "/getById/{id}/**")
    public @ResponseBody User getById(@PathVariable final Integer id) {
        return userDao.getOne(id);
    }

    @PostMapping(path = "/add/**")
    public @ResponseBody List<User> addNew(@RequestBody final User user) {
        userDao.save(user);
        return userDao.findAll();
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        userDao.deleteById(id);
    }

    @PutMapping(path = "/update/**")
    public void update(@RequestBody final User user) {
        userDao.saveAndFlush(user);
    }
}
