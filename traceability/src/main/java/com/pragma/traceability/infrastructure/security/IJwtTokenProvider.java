package com.pragma.traceability.infrastructure.security;


import io.jsonwebtoken.Claims;

public interface IJwtTokenProvider {
    boolean isTokenValid(String token);
    Claims getClaims(String token);
    public String getEmailFromToken(String token);
}
