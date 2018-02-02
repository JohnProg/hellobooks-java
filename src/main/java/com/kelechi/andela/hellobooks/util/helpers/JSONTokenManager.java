package com.kelechi.andela.hellobooks.util.helpers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JSONTokenManager {
    public static String createJWT(Long id, String email, String username){

        final String subject = "users/hellobooks";
        final Long timeout = Long.valueOf(60 * 60);

        String jwt = null;
        try {
            jwt = Jwts.builder()
                    .setSubject(subject)
                    .setExpiration(new Date(timeout))
                    .claim("email", email)
                    .claim("userId", id)
                    .claim("username", username)
                    .signWith(
                            SignatureAlgorithm.HS256,
                            "secret".getBytes("UTF-8")
                    )
                    .compact();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jwt;
    }
}
