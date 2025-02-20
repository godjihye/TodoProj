package com.jhshin.todoproj.security;

import com.jhshin.todoproj.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class TokenProvider {
    private static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public String create(UserEntity userEntity) {
        Date expiryDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        /*
            { // header
                "alg":"HS512"
            },
            { // payload
                "sub":"40288093784915d201784916a40c0001",
                "iss": "demo app",
                "iat":1595733657,
                "exp":1596597657
            },
            // SECRET_KEY를 이용해 서명한 부분
            Nn4d1MOVLZg79sfFACTIpCPKqWmpZMZQsbNrXdJJNWkRv50_l7bPLQPwhMobT4vBOG6Q3JYjhDrKFlBSaUxZOg
        */

        return Jwts.builder()
                // header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
                .signWith(SECRET_KEY)
                // payload에 들어갈 내용
                .subject(userEntity.getId()) // sub
                .issuer("demo app") // iss
                .issuedAt(new Date()) // iat
                .expiration(expiryDate) // exp
                .compact();

        }

    public String validateAndGetUserId(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getBody();
        return claims.getSubject();

    }
}
