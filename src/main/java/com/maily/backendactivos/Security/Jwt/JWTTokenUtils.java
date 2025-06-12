package com.maily.backendactivos.Security.Jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.maily.backendactivos.Security.TokenPayload;
import com.maily.backendactivos.Security.TokenUtils;
import com.maily.backendactivos.Model.User;

import org.springframework.stereotype.Component;

@Component
public class JWTTokenUtils extends TokenUtils {
    public TokenPayload decodeToken(String authorizationHeader) {
        DecodedJWT decodedToken = JWT.require(Algorithm.HMAC512(getSecret().getBytes()))
                .build()
                .verify(authorizationHeader.replace(getTokenPrefix(), ""));

        return new TokenPayload(decodedToken.getSubject(), decodedToken.getClaim("role").as(User.Role.class));
    }
}