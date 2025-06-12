package com.maily.backendactivos.Security;


import com.maily.backendactivos.Model.User;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TokenPayload {
    private final String username;
    private final User.Role role;

    public TokenPayload(String username, User.Role role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public User.Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("role", role)
                .toString();
    }
}