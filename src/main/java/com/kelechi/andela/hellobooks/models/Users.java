package com.kelechi.andela.hellobooks.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="FIRST_NAME", nullable = false, length = 50)
    private String firstname;

    @Column(name ="LAST_NAME", nullable = false, length = 50)
    private String lastname;

    @Column(name ="EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name ="USERNAME", nullable = false, length = 15)
    private String username;

    @Column(name ="PASSWORD", nullable = false, length = 100)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_TYPE_ID", referencedColumnName = "ID")
    private UserType userType;

    public Users() {

    }

    public Users(String firstname, String lastname, String email, String username, String password, UserType userType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
