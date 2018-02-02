package com.kelechi.andela.hellobooks.util.response;

import com.kelechi.andela.hellobooks.models.Users;

public class AuthenticationResponse {
    private String token;
    private boolean success;
    private String message;
    private Users user;



    public AuthenticationResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public AuthenticationResponse() {

    }

    public AuthenticationResponse( String token, boolean success, String message, Users user) {
        this.token = token;
        this.success = success;
        this.message = message;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
