package com.thoughtworks.learnangularjs.serialization;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.learnangularjs.domain.Amount;
import com.thoughtworks.learnangularjs.domain.Book;
import org.junit.Test;

public class BookSerializerTest {
    @Test
    public void testShouldSerializeBook() throws Exception {
        Book book = new Book("book title", Arrays.asList("author 1", "author 2"), "book description", "book isbn13", new Amount("0.3"));

        String actualJsonBook = new ObjectMapper().writeValueAsString(book);

        String expectedJsonBook = "{" +
                "'id':'" + book.getId().toString() + "'," +
                "'title':'book title'," +
                "'authors':['author 1','author 2']," +
                "'description':'book description'," +
                "'isbn13':'book isbn13'," +
                "'price':'0.30'}";

        assertThat(actualJsonBook, sameJSONAs(expectedJsonBook));
    }
}
