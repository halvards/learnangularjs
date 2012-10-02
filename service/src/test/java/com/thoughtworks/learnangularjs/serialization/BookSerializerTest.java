package com.thoughtworks.learnangularjs.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.learnangularjs.domain.Amount;
import com.thoughtworks.learnangularjs.domain.Book;
import com.thoughtworks.learnangularjs.domain.BookBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookSerializerTest {
    @Test
    public void testShouldSerializeBook() throws Exception {
        Book book = new BookBuilder()
                .withId(UUID.fromString("9f726709-7f0b-406e-a07b-845d931503a8"))
                .withTitle("book title")
                .withAuthors(Arrays.asList("author 1", "author 2"))
                .withDescription("book description")
                .withIsbn13("book isbn13")
                .withPrice(new Amount("0.3"))
                .build();

        String actualJsonBook = new ObjectMapper().writeValueAsString(book);

        String expectedJsonBook = "{" +
                "\"id\":\"9f726709-7f0b-406e-a07b-845d931503a8\"," +
                "\"title\":\"book title\"," +
                "\"authors\":[\"author 1\",\"author 2\"]," +
                "\"description\":\"book description\"," +
                "\"isbn13\":\"book isbn13\"," +
                "\"price\":\"0.30\"}";

        assertThat(actualJsonBook, equalTo(expectedJsonBook));
    }
}
