package com.cybersoft.osahaneat.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;  // Import Spring component annotation

import javax.crypto.SecretKey;

@Component  // Add Spring component annotation
public class JwtUtilsHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;  // Move the @Value annotation to a class field

    public String generateToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().subject(data).signWith(key).compact();
        return jws;
    }
}
