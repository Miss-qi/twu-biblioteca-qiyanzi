package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    @Test
    public void shouldReturnMovieDetail() {
        Movie movie = new Movie("Movie name", "2010", "Movie director", 2);
        assertEquals("Movie name", movie.getMovieName());
        assertEquals("Movie year", movie.getYear());
        assertEquals("Movie director", movie.getDirector());
        assertEquals(2, movie.getRating());
    }

    @Test
    public void shouldReturnOneMovieDetail() {
        Movie movie = new Movie("Movie name", "2022", "Movie director", 2);
        assertEquals("movieName:Movie name year:2022 director:Movie director" + " rating:" + 2, movie.getMovieDetail());
    }
}