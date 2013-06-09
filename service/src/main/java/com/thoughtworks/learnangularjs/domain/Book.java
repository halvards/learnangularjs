package com.thoughtworks.learnangularjs.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Book {
    private final Map<String, Object> book;

    public Book(String title, List<String> authors, String description, String isbn13, Amount price) {
        this.book = new ImmutableMap.Builder<String, Object>()
                .put("id", UUID.randomUUID())
                .put("title", title)
                .put("authors", ImmutableList.copyOf(authors))
                .put("description", description)
                .put("isbn13", isbn13)
                .put("price", price)
                .build();
    }

    @JsonCreator
    Book(Map<String, Object> book) {
        this.book = ImmutableMap.copyOf(book);
    }

    public UUID getId() {
        return UUID.fromString(book.get("id").toString());
    }

    public String getTitle() {
        return book.get("title").toString();
    }

    @SuppressWarnings("unchecked")
    public List<String> getAuthors() {
        return ImmutableList.copyOf((List<String>) book.get("authors"));
    }

    public String getDescription() {
        return book.get("description").toString();
    }

    public String getIsbn13() {
        return book.get("isbn13").toString();
    }

    public Amount getPrice() {
        return new Amount(book.get("price").toString());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
