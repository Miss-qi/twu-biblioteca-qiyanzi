package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private Library library;
    private PrintStream printStream;
    private Display display;
    private Menu menu;
    private List<Book> bookList;
    private List<Book> checkedoutBookList;
    private List<Movie> movieList;
    private List<Movie> checkedoutMovieList;

    @Before
    public void setUp() {
        library = mock(Library.class);
        printStream = mock(PrintStream.class);
        display = mock(Display.class);

        menu = new Menu(library, printStream, display);
        when(display.getUserInput()).thenReturn("1", "Q");

        bookList = new ArrayList<Book>();
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        bookList.add(book1);
        bookList.add(book2);

        checkedoutBookList = new ArrayList<Book>();
        Book checkedoutBook1 = mock(Book.class);
        Book checkedoutBook2 = mock(Book.class);
        checkedoutBookList.add(checkedoutBook1);
        checkedoutBookList.add(checkedoutBook2);

        movieList = new ArrayList<Movie>();
        Movie movie1 = mock(Movie.class);
        Movie movie2 = mock(Movie.class);
        movieList.add(movie1);
        movieList.add(movie2);

        checkedoutMovieList = new ArrayList<Movie>();
        Movie checkedoutMovie1 = mock(Movie.class);
        Movie checkedoutMovie2 = mock(Movie.class);
        checkedoutMovieList.add(checkedoutMovie1);
        checkedoutMovieList.add(checkedoutMovie2);
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenStarting() {
        menu.selectOption(1);
        verify(display).displayWelcomeMessage();
    }

    @Test
    public void shouldDisplayMessageWhenGetInvalidOption() {
        when(display.getUserInput()).thenReturn("666", "1", "Q");
        menu.selectOption(1);
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldDisplayBookListWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("1", "Q");
        menu.selectOption(1);
        verify(library).displayBooksWithBookNumber();
    }

    @Test
    public void shouldCheckoutBookWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("2", "Q");
        menu.selectOption(1);
        verify(library).checkoutBook();
    }

    @Test
    public void shouldReturnBookWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("3", "Q");
        menu.selectOption(1);
        verify(library).returnBook();
    }

    @Test
    public void shouldDisplayMovieListWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("4", "Q");
        menu.selectOption(1);
        verify(library).displayMoviesWithMovieNumber();
    }

    @Test
    public void shouldCheckoutMovieWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("5", "Q");
        menu.selectOption(1);
        verify(library).checkoutMovie();
    }

    @Test
    public void shouldReturnMovieWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("6", "Q");
        menu.selectOption(1);
        verify(library).returnMovie();
    }

    @Test
    public void shouldReturnUserInfoWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("7", "Q");
        menu.selectOption(1);
        verify(library).displayUserInformation(1);
    }
}
