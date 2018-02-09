package com.kelechi.andela.hellobooks.util.response;

import com.kelechi.andela.hellobooks.models.Users;

import java.util.List;

public class UsersResponse {
    private String message;
    private boolean success;
    private List<Users> users;

    public UsersResponse() {
    }

    public List<Users> getUsers() {
        return users;
    }

    public UsersResponse(String message, boolean success, List<Users> users) {

        this.message = message;
        this.success = success;
        this.users = users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
