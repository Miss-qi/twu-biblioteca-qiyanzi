package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        PrintStream printStream = System.out;
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        Display display = new Display(printStream, reader);
        Library library = new Library(bookList(), printStream,
                checkedoutBookList(), display);
        Menu menu = new Menu(library, printStream, display);
        menu.selectOption();
    }

    public static List<Book> bookList() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("Book1 name", "Book1 author", "2000");
        bookList.add(book1);
        Book book2 = new Book("Book2 name", "Book2 author", "2010");
        bookList.add(book2);

        return bookList;
    }

    public static List<Book> checkedoutBookList() {
        List<Book> checkedoutBookList = new ArrayList<Book>();
        Book checkedoutBook1 = new Book("CheckedoutBook1 name", "CheckedoutBook1 author", "2020");
        checkedoutBookList.add(checkedoutBook1);
        Book checkedoutBook2 = new Book("CheckedoutBook2 name", "CheckedoutBook2 author", "2030");
        checkedoutBookList.add(checkedoutBook2);

        return checkedoutBookList;
    }
}
