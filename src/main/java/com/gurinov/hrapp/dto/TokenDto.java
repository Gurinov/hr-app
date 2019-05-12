package com.gurinov.hrapp.dto;

import lombok.Data;

@Data
public class TokenDto {
    private String token;

    public TokenDto(final String token) {
        this.token = token;
    }
}
