package com.gurinov.hrapp.dto;

import com.gurinov.hrapp.enums.State;
import com.gurinov.hrapp.model.User;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private State state;
    private RoleDto role;

    public UserDto(final User user) {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        name = user.getName();
        surname = user.getSurname();
        state = user.getState();
        role = new RoleDto(user.getRole());
    }

    public UserDto(final String email, final String password) {
        id = 0;
        this.email = email;
        this.password = password;
    }
}
