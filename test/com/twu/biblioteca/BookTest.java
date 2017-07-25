package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {
    @Test
    public void shouldReturnBookDetail() {
        Book book = new Book("Book1 name", "Book1 author", "2017");
        assertEquals("title:Book1 name author:Book1 author publishDate:2017", book.getBookDetail());
    }
}
