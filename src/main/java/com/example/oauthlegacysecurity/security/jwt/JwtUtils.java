package com.example.oauthlegacysecurity.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import java.security.Key;
import java.util.Base64;

@Component
@Slf4j
public class JwtUtils {
    public String getJwtFromCookies(HttpServletRequest httpServletRequest) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, "jwt");

        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public String getUserNameFromJwtToken(String jwt) {
        try {
            Claims body = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(jwt).getBody();

            return body.getSubject();
        } catch (JwtException | ClassCastException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
            return null;
        }
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("secret"));
    }
    public String generateJwtToken(String username) {
        return "jwt";
    }



}
