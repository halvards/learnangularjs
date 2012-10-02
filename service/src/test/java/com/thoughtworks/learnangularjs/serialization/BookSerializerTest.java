package com.thoughtworks.learnangularjs.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.learnangularjs.domain.Amount;
import com.thoughtworks.learnangularjs.domain.Book;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.refEq;

public class BookSerializerTest {
    @Test
    public void testShouldSerializeBook() throws Exception {
        Book book = new Book("book title", Arrays.asList("author 1", "author 2"), "book description", "book isbn13", new Amount("0.3"));

        ObjectMapper objectMapper = new ObjectMapper();
        String actualJson = objectMapper.writeValueAsString(book);
        System.out.println(actualJson);
        Book book1 = objectMapper.readValue(actualJson, Book.class);
//        assertThat(book1, refEq(book));
    }
}
