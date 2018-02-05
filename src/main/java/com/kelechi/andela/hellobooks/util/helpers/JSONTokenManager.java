package com.kelechi.andela.hellobooks.util.helpers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JSONTokenManager {

    private static  final Long  TOKEN_TIMEOUT = Long.valueOf(60 * 60);
    private static final String TOKEN_SUBJECT = "users/hellobooks";
    private static final String TOKEN_SECRET = "hellobooks-secret";

    public static String createJWT(Long id, String email, String username){


        String jwt = null;
        try {
            jwt = Jwts.builder()
                    .setSubject(TOKEN_SUBJECT)
                    .setExpiration(new Date(TOKEN_TIMEOUT))
                    .claim("email", email)
                    .claim("userId", id)
                    .claim("username", username)
                    .signWith(
                            SignatureAlgorithm.HS256,
                            TOKEN_SECRET.getBytes("UTF-8")
                    )
                    .compact();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jwt;
    }
}
