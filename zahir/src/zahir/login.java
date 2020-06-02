package zahir ;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

public class token1 {
    public static void main(String[] args)
    {
        Instant now = Instant.now();
        byte[] secret= Base64.getDecoder().decode("jZ3DUmVv4xYiw+V5V/1f6KrtSAWsb+bBKZbaZXnPWNbRTlEywYIC+Q9bwZg1tHWBJMt3jPfKQgoMT7G4wsvPV7I3tOW6Yr5X6p74pDZY8akQX7+8PUnzzwxwssj+LMek4nB2GSFTZdOe1p+OnA4ujko+yAFncnytI2wmFJ35UNkAQAB=");
        String jwt=Jwts.builder()
                .setSubject("zahir11")
                .setAudience("paswor3d")
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(20).toInstant()))
                .signWith(Keys.hmacShaKeyFor(secret))
                .compact();
        System.out.println(jwt);
         Jws<Claims> result= Jwts.parser()
                 .setSigningKey(Keys.hmacShaKeyFor(secret))
                 .parseClaimsJws(jwt);



         System.out.println(result);
         System.out.println("Emri:"+result.getBody().getExpiration() +decodeJWT(jwt).getSubject());


    }
 

}
