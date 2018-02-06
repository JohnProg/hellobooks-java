package com.kelechi.andela.hellobooks.util.helpers;

import io.jsonwebtoken.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JSONTokenManager {

    private static  final int  TOKEN_TIMEOUT_IN_MINUTES = 1;
    private static final String TOKEN_SUBJECT = "users/hellobooks";
    private static final String TOKEN_SECRET = "hellobooks-secret";

    public static String createJWT(Long id, String email, String username){


        String jwt = null;
        try {
            jwt = Jwts.builder()
                    .setSubject(TOKEN_SUBJECT)
                    .setExpiration(getExpirationTime())
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

    public static Jws<Claims> decodeToken(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException{
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET.getBytes("UTF-8"))
                    .parseClaimsJws(token);
            return claims;
        } catch (ExpiredJwtException e) {
            throw new MalformedJwtException("Token has expired", e);
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            return null;
        } catch (MalformedJwtException e) {
            throw new MalformedJwtException("Token is invalid and malformed", e);
        } catch (SignatureException e) {
            throw  new SignatureException("Token is invalid and malformed", e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Date getExpirationTime(){
        long nowTimeMillis = System.currentTimeMillis();
        long expirationTime = nowTimeMillis + (60 * 1000 * TOKEN_TIMEOUT_IN_MINUTES);
        return new Date(expirationTime);
    }

}
