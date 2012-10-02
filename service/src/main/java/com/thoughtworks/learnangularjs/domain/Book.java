package com.thoughtworks.learnangularjs.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;
import java.util.UUID;

@JsonDeserialize(builder = BookBuilder.class)
public class Book {
    private final UUID id;
    private final String title;
    private final List<String> authors;
    private final String description;
    private final String isbn13;
    private final Amount price;

    public Book(String title, List<String> authors, String description, String isbn13, Amount price) {
        this(UUID.randomUUID(), title, authors, description, isbn13, price);
    }

    // Required for JSON deserialization via BookBuilder
    Book(UUID id, String title, List<String> authors, String description, String isbn13, Amount price) {
        this.id = Preconditions.checkNotNull(id);
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

    public Amount getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
