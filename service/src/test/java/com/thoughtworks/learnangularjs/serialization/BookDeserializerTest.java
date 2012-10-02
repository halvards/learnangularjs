package com.thoughtworks.learnangularjs.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.learnangularjs.domain.Amount;
import com.thoughtworks.learnangularjs.domain.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookDeserializerTest {
    @Test
    public void testDeserializeBook() throws Exception {
        String jsonBook = "{" +
                "\"id\":\"9f726709-7f0b-406e-a07b-845d931503a8\"," +
                "\"title\":\"book title\"," +
                "\"authors\":[\"author 1\",\"author 2\"]," +
                "\"description\":\"book description\"," +
                "\"isbn13\":\"book isbn13\"," +
                "\"price\":\"0.30\"}";

        Book book = new ObjectMapper().readValue(jsonBook, Book.class);

        assertThat(book.getId(), equalTo(UUID.fromString("9f726709-7f0b-406e-a07b-845d931503a8")));
        assertThat(book.getTitle(), equalTo("book title"));
        assertThat(book.getAuthors(), equalTo(Arrays.asList("author 1", "author 2")));
        assertThat(book.getDescription(), equalTo("book description"));
        assertThat(book.getIsbn13(), equalTo("book isbn13"));
        assertThat(book.getPrice(), equalTo(new Amount("0.3")));
    }
}
