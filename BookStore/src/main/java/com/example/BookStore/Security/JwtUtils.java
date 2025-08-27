package com.example.BookStore.Security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private String SECRET = "mysuperlongsecretkeythatshouldbeatladdedeast64characterslongforhs512";

    private SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    public String generateToken(String username){
        return Jwts.builder()
                .signWith(key,SignatureAlgorithm.HS512)
                .issuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+8640000))
                .setSubject(username)
                .compact();
    }

    public String extractUsername(String token){
        Key keys = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts.parser()
                .verifyWith((SecretKey) keys)
                .build()
                .parseSignedClaims(token)
                .getPayload().getSubject();

    }
    public boolean isExpired(String token){
        Key keys = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        Date date= Jwts.parser()
                .verifyWith((SecretKey) keys)
                .build()
                .parseSignedClaims(token)
                .getPayload().getExpiration();
        return date.before(new Date());

    }


}
