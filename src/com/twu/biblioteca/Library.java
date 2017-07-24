package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private PrintStream printStream;
    private List<Book> checkedOutBooks;
    private Display display;

    public Library(List<Book> bookList, PrintStream printStream,
                   List<Book> checkedOutBooks, Display display) {
        this.bookList = bookList;
        this.printStream = printStream;
        this.checkedOutBooks = checkedOutBooks;
        this.display = display;
    }

    public void displayBooks() {
        for (Book book : bookList) {
            printStream.println(book.getBookDetail());
        }
    }

    public void displayBooksWithBookNumber() {
        System.out.println(bookList.size());
        for (int i = 1; i <= bookList.size(); i++) {
            printStream.print(i + ". ");
            printStream.println(bookList.get(i - 1).getBookDetail());
        }
    }

    public void checkoutBook() {
        printStream.println("Which book would you like to check out?");
        displayBooksWithBookNumber();
        String userInput = display.getUserInput();
        int index = Integer.parseInt(userInput) - 1;
        if (index >= 0 && index < bookList.size()) {
            Book book = bookList.remove(index);
            checkedOutBooks.add(book);
            printStream.println("Thank you! Enjoy your book.");
        } else {
            printStream.println("That book is not available.");
        }
    }

    public void displayCheckedoutBooksWithBookNumber() {
        for (int i = 1; i <= checkedOutBooks.size(); i++) {
            printStream.print(i + ". ");
            printStream.println(checkedOutBooks.get(i - 1).getBookDetail());
        }
    }

    public void returnBook() {
        printStream.println("Which book would you want to return?");
        displayCheckedoutBooksWithBookNumber();
        String userInput = display.getUserInput();
        int index = Integer.parseInt(userInput) - 1;
        if (index >= 0 && index < checkedOutBooks.size()) {
            Book book = checkedOutBooks.remove(index);
            bookList.add(book);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }
}
