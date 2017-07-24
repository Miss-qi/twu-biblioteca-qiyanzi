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

        library = new Library(bookList, printStream, checkedOutBookList, display);
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
}
