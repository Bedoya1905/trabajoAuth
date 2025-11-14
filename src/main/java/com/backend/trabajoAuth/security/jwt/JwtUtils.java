package com.backend.trabajoAuth.security.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import com.backend.trabajoAuth.security.services.UserDetailsImpl;
import com.backend.trabajoAuth.security.services.UserDetailsServiceImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${backend.app.jwtSecret}")
    private String jwtSecret;

    @Value("${backend.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private SecretKey key() {

        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .subject(userPrincipal.getUsername())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key())
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .verifyWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parseSignedClaims(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token JWT es invalido: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("Token JWT esta expirado: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Token JWT no esta soportado: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Token afirma que la caden es vacia: {}", e.getMessage());
        } catch (JwtException e) {
            logger.error("Error JWT: {}", e.getMessage());
        }

        return false;
    }
}
