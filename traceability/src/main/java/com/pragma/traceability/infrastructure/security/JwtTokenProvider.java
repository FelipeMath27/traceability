package com.pragma.traceability.infrastructure.security;


import com.pragma.traceability.infrastructure.constant.ConstantInfrastructure;
import com.pragma.traceability.infrastructure.exceptions.InfrastructureException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;


@Component
@Slf4j
public class JwtTokenProvider implements IJwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Long validateTime;

    private byte[] secretKey;

    @PostConstruct
    public void init(){
        this.secretKey = Base64.getDecoder().decode(jwtSecret);
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);
            boolean isValid = claims.getExpiration().after(new Date());
            if (!isValid) {
                log.warn("{}: {}", ConstantInfrastructure.EXPIRED_TOKEN, claims.getSubject());
            }
            return isValid;
        } catch (JwtException | IllegalArgumentException e){
            log.error("{}: {}",ConstantInfrastructure.ERROR_TO_VALIDATE_TOKEN, e.getMessage());
            throw new InfrastructureException(ConstantInfrastructure.ERROR_TO_VALIDATE_TOKEN);
        }
    }

    @Override
    public Claims getClaims(String token) {
        return (Claims) Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secretKey))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    @Override
    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }
}
