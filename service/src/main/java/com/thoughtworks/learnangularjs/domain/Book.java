package com.thoughtworks.learnangularjs.domain;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Book {
    private final UUID id;
    private final String title;
    private final List<String> authors;
    private final String description;
    private final String isbn13;
    private final BigDecimal price;

    public Book(String title, List<String> authors, String description, String isbn13, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.title = Preconditions.checkNotNull(title);
        this.authors = ImmutableList.copyOf(Preconditions.checkNotNull(authors));
        this.description = Preconditions.checkNotNull(description);
        this.isbn13 = Preconditions.checkNotNull(isbn13);
        this.price = Preconditions.checkNotNull(price);
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
