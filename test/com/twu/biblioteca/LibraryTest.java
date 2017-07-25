package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LibraryTest {
    private PrintStream printStream;
    private List<Book> bookList;
    private Library library;
    private Book book1;
    private List<Book> checkedOutBookList;
    private Display display;
    private List<Movie> movieList;
    private Movie movie1;
    private List<Movie> checkedoutMovieList;
    private List<User> userList;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        display = mock(Display.class);

        bookList = new ArrayList<Book>();
        book1 = mock(Book.class);
        bookList.add(book1);

        checkedOutBookList = new ArrayList<Book>();
        Book checkedoutBook1 = mock(Book.class);
        checkedOutBookList.add(checkedoutBook1);
        Book checkedoutBook2 = mock(Book.class);
        checkedOutBookList.add(checkedoutBook2);

        movieList = new ArrayList<Movie>();
        movie1 = mock(Movie.class);
        movieList.add(movie1);

        checkedoutMovieList = new ArrayList<Movie>();
        Movie checkedoutMovie1 = mock(Movie.class);
        Movie checkedoutMovie2 = mock(Movie.class);
        checkedoutMovieList.add(checkedoutMovie1);
        checkedoutMovieList.add(checkedoutMovie2);

        userList = new ArrayList<User>();
        User user1 = mock(User.class);
        userList.add(user1);

        library = new Library(bookList, printStream, checkedOutBookList,
                display, movieList, checkedoutMovieList, userList);
    }

    @Test
    public void shouldDisplayOneBookWhenBookListHasOneBook() {
        library.displayBooks();
        verify(book1).getBookDetail();
    }

    @Test
    public void shouldDisplayBookList() {
        Book book2 = mock(Book.class);
        bookList.add(book2);
        library.displayBooks();
        for (Book book : bookList) {
            verify(book).getBookDetail();
        }
    }

    @Test
    public void shouldDisplayBooksWithBookNumber() {
        Book book2 = mock(Book.class);
        bookList.add(book2);
        library.displayBooksWithBookNumber();
        for (Book book : bookList) {
            verify(book).getBookDetail();
        }
        verify(printStream).print("1. ");
        verify(printStream).print("2. ");
    }

    @Test
    public void shouldCheckoutSelectedBook() {
        when(display.getUserInput()).thenReturn("1");
        library.checkoutBook();
        printStream.println("Which book would you like to check out?");
        verify(printStream).println("Thank you! Enjoy your book.");
    }

    @Test
    public void shouldDisplayMessageWhenCheckoutFailed() {
        when(display.getUserInput()).thenReturn("2333");
        library.checkoutBook();
        printStream.println("Which book would you like to check out?");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayCheckedoutBooksWithBookNumber() {
        library.displayCheckedoutBooksWithBookNumber();
        for (Book book : checkedOutBookList) {
            verify(book).getBookDetail();
        }
        verify(printStream).print("1. ");
        verify(printStream).print("2. ");
    }

    @Test
    public void shouldDisplayMessageWhenReturnBookSuccessful() {
        when(display.getUserInput()).thenReturn("1");
        library.returnBook();
        verify(printStream).println("Which book would you want to return?");
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldDisplayMessageWhenReturnBookFailed() {
        when(display.getUserInput()).thenReturn("6666");
        library.returnBook();
        verify(printStream).println("Which book would you want to return?");
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldDisplayMoviesWithMovieNumber() {
        Movie movie2 = mock(Movie.class);
        movieList.add(movie2);

        library.displayMoviesWithMovieNumber();
        for (Movie movie : movieList) {
            verify(movie).getMovieDetail();
        }
        verify(printStream).print("1. ");
        verify(printStream).print("2. ");
    }

    @Test
    public void shouldCheckoutSelectedMovie() {
        when(display.getUserInput()).thenReturn("1");
        library.checkoutMovie();
        printStream.println("Which movie would you like to check out?");
        verify(printStream).println("Thank you! Enjoy your movie.");
    }

    @Test
    public void shouldDisplayMessageWhenCheckoutMovieFailed() {
        when(display.getUserInput()).thenReturn("2333");
        library.checkoutMovie();
        printStream.println("Which movie would you like to check out?");
        verify(printStream).println("That movie is not available.");
    }

    @Test
    public void shouldDisplayCheckedoutMoviesWithMovieNumber() {
        library.displayCheckedoutMoviesWithMovieNumber();
        for (Movie movie : checkedoutMovieList) {
            verify(movie).getMovieDetail();
        }
        verify(printStream).print("1. ");
        verify(printStream).print("2. ");
    }

    @Test
    public void shouldDisplayMessageWhenReturnMovieSuccessful() {
        when(display.getUserInput()).thenReturn("1");
        library.returnMovie();
        verify(printStream).println("Which movie would you want to return?");
        verify(printStream).println("Thank you for returning the movie.");
    }

    @Test
    public void shouldDisplayMessageWhenReturnMovieFailed() {
        when(display.getUserInput()).thenReturn("6666");
        library.returnMovie();
        verify(printStream).println("Which movie would you want to return?");
        verify(printStream).println("That is not a valid movie to return.");
    }
}
