package org.team24.coursesmanager.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JWTUtil {

    public String generateToken(String username){
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(60).toInstant());

        return JWT.create()
                .withSubject("User details")
                .withClaim("username", username)
                .withIssuedAt(new Date())
                .withIssuer("coursesmanager")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256("secret"));
    }


    public String validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
       JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .withSubject("User details")
                .withIssuer("coursesmanager")
                .build();

        DecodedJWT jwt = verifier.verify(token);
       return jwt.getClaim("username").asString();
    }
}
