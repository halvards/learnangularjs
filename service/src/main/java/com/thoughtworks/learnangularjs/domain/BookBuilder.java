package com.thoughtworks.learnangularjs.domain;

import java.util.List;
import java.util.UUID;

public class BookBuilder {
    private UUID id;
    private String title;
    private List<String> authors;
    private String description;
    private String isbn13;
    private Amount price;

    public BookBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    public BookBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public BookBuilder withIsbn13(String isbn13) {
        this.isbn13 = isbn13;
        return this;
    }

    public BookBuilder withPrice(Amount price) {
        this.price = price;
        return this;
    }

    public Book build() {
        return id != null ? new Book(id, title, authors, description, isbn13, price) : new Book(title, authors, description, isbn13, price);
    }
}
