package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {
    @Test
    public void shouldReturnBookDetail() {
        Book book = new Book("Book1 name", "Book1 author", "2017");
        assertEquals("Book1 name Book1 author 2017", book.getBookDetail());
    }
}
