package com.cybersoft.osahaneat.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;  // Import Spring component annotation

import javax.crypto.SecretKey;
import java.security.Key;

@Component  // Add Spring component annotation
public class JwtUtilsHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;  // Move the @Value annotation to a class field

    public String generateToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().subject(data).signWith(key).compact();
        return jws;
    }
    public boolean verifyToken(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parser().
                    setSigningKey(key).
                    build().
                    parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public String getDataFromToken(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            return Jwts.parser().
                    setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e){
            return "";
        }
    }
}
