package com.gurinov.hrapp.model;

import com.gurinov.hrapp.dto.RoleDto;
import com.gurinov.hrapp.dto.UserDto;
import com.gurinov.hrapp.enums.State;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUser implements UserDetails {

    @Getter
    private Integer id;

    private String email;
    private String password;

    @Getter
    private String name;

    @Getter
    private String surname;

    @Getter
    private State state;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(final UserDto user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.state = user.getState();
        this.isEnabled = user.getState().equals(State.ACTIVE);
        this.authorities = mapToGrantedAuthorities(user.getRole());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(final RoleDto userRole) {
        List<RoleDto> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
