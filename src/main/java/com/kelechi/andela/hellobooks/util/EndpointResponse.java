package com.kelechi.andela.hellobooks.util;

public class EndpointResponse {

    private String message;

    public EndpointResponse(String message) {
        this.message = message;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EndpointResponse() {

    }
}
