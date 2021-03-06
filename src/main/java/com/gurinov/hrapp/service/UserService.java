package com.gurinov.hrapp.service;

import com.gurinov.hrapp.dao.UserDao;
import com.gurinov.hrapp.dto.UserDto;
import com.gurinov.hrapp.enums.State;
import com.gurinov.hrapp.model.Role;
import com.gurinov.hrapp.model.User;
import com.gurinov.hrapp.security.TokenProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public final class UserService implements UserDetailsService, EntityService<User, UserDto> {

    private final TokenProvider jwtTokenUtil;
    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(
            final BCryptPasswordEncoder passwordEncoder,
            final UserDao userDao,
            final TokenProvider jwtTokenUtil
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
        this.jwtTokenUtil = jwtTokenUtil;
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
        final Role role = new Role(2, "USER");
        obj.setPassword(passwordEncoder.encode(obj.getPassword()));
        obj.setRole(role);
        obj.setState(State.ACTIVE);
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

    public UserDto findByEmail(final String email) {
        List<UserDto> users = findAll();
        for (UserDto user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDto user = findByEmail(username);
        if (user == null) {
            return null;
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthority(user)
        );
    }

    private Set<SimpleGrantedAuthority> getAuthority(final UserDto user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
        return authorities;
    }

    public UserDto findUserByToken(final String authToken) {
        String username = null;
        if (authToken != null) {
            username = jwtTokenUtil.getUsernameFromToken(authToken);
        }
        if (username != null) {
            return findByEmail(username);
        }
        return null;
    }
}
