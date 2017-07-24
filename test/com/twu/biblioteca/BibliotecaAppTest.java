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
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenStarting() {
        menu.selectOption();
        verify(display).displayWelcomeMessage();
    }

    @Test
    public void shouldDisplayMessageWhenGetInvalidOption() {
        when(display.getUserInput()).thenReturn("666", "1", "Q");
        menu.selectOption();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldDisplayBookListWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("1", "Q");
        menu.selectOption();
        verify(library).displayBooksWithBookNumber();
    }

    @Test
    public void shouldCheckoutBookWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("2", "Q");
        menu.selectOption();
        verify(library).checkoutBook();
    }

    @Test
    public void shouldReturnBookWhenGetValidOption() {
        when(display.getUserInput()).thenReturn("3", "Q");
        menu.selectOption();
        verify(library).returnBook();
    }
}
