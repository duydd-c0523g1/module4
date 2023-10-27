package com.library_manager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String bookCover;
    private String description;
    private String author;
    private int remaining;
    @OneToMany(mappedBy = "book")
    private Set<RentalContract> rentalContracts;

    public Book() {
    }

    public Book(Integer id, String title, String bookCover, String description, String author, int remaining, Set<RentalContract> rentalContracts) {
        this.id = id;
        this.title = title;
        this.bookCover = bookCover;
        this.description = description;
        this.author = author;
        this.remaining = remaining;
        this.rentalContracts = rentalContracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public Set<RentalContract> getRentCodes() {
        return rentalContracts;
    }

    public void setRentCodes(Set<RentalContract> rentalContracts) {
        this.rentalContracts = rentalContracts;
    }
}
