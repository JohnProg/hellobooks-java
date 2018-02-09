package com.kelechi.andela.hellobooks.models;

import javax.persistence.*;

@Entity
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    public BookCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BookCategory() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
