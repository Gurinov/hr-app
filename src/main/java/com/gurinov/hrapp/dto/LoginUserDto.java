package com.gurinov.hrapp.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;
    private String password;

    public LoginUserDto() {
    }

    public LoginUserDto(final String email, final String password) {
        this.email = email;
        this.password = password;
    }
}
