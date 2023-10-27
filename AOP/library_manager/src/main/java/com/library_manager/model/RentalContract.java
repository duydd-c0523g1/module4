package com.library_manager.model;

import javax.persistence.*;

@Entity
@Table(name = "contracts")
public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int code;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Book book;

    public RentalContract() {
    }

    public RentalContract(int code, Book book) {
        this.code = code;
        this.book = book;
    }

    public RentalContract(Integer id, int code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
