package com.gurinov.hrapp.controller;

import com.gurinov.hrapp.dto.LoginUserDto;
import com.gurinov.hrapp.dto.TokenDto;
import com.gurinov.hrapp.dto.UserDto;
import com.gurinov.hrapp.model.User;
import com.gurinov.hrapp.security.TokenProvider;
import com.gurinov.hrapp.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 36000000)
@RestController
@RequestMapping(path = "/user")
public final class UserController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider jwtTokenUtil;
    private final UserService userService;

    @Value("${jwt.token.header}")
    private String header;

    public UserController(
            final UserService userService,
            final AuthenticationManager authenticationManager,
            final TokenProvider jwtTokenUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping(path = "")
    public @ResponseBody
    List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{id}/**")
    public @ResponseBody
    UserDto findById(@PathVariable final Integer id) {
        return userService.findById(id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity create(@Valid @RequestBody final User user, final BindingResult result) {
        if (result.hasErrors() || userService.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
        userService.create(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping(path = "/findUserByToken")
    public UserDto getUserByToken(final HttpServletRequest req) {
        return userService.findUserByToken(req.getHeader(header));
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable final Integer id) {
        userService.delete(id);
    }

    @PutMapping(path = "/update")
    public UserDto update(@RequestBody final User user) {
        return userService.update(user);
    }

    @PostMapping("login")
    public ResponseEntity login(final @RequestBody LoginUserDto loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new TokenDto(token));
    }


}
