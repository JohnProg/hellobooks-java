package com.kelechi.andela.hellobooks.models;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(length = 30)
    private String isbn;

    @Column
    private long quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_CATEGORY", referencedColumnName = "ID")
    private BookCategory bookCategory;

    public Books() {
    }

    public Books(String name, String author, String isbn, long quantity, BookCategory bookCategory) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
        this.bookCategory = bookCategory;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
