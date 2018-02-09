package com.kelechi.andela.hellobooks.models;

import com.kelechi.andela.hellobooks.enums.UserTypeEnum;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "USER_TYPE")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "TYPE")
    UserTypeEnum usertype;

    public UserType() {

    }

    public UserType(UserTypeEnum usertype) {

        this.usertype = usertype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserTypeEnum getUsertype() {
        return usertype;
    }

    public void setUsertype(UserTypeEnum usertype) {
        this.usertype = usertype;
    }
}
