package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.UserDto;
import com.gurinov.hrapp.model.User;
import com.gurinov.hrapp.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public final class UserController {

    private final EntityService<User, UserDto> userService;

    public UserController(final EntityService<User, UserDto> userService) {
        this.userService = userService;
    }

    @GetMapping(path = "")
    public @ResponseBody List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/findById/{id}/**")
    public @ResponseBody UserDto findById(@PathVariable final Integer id) {
        return userService.findById(id);
    }

    @PostMapping(path = "/add/**")
    public void create(@RequestBody final User user) {
        userService.create(user);
    }

    @DeleteMapping(path = "/delete/{id}/**")
    public void delete(@PathVariable final Integer id) {
        userService.delete(id);
    }

    @PutMapping(path = "/update/**")
    public UserDto update(@RequestBody final User user) {
        return userService.update(user);
    }
}
