package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private PrintStream printStream;
    private List<Book> checkedOutBooks;
    private Display display;
    private List<Movie> movieList;
    private List<Movie> checkedoutMovieList;
    private List<User> userList;

    public Library(List<Book> bookList, PrintStream printStream,
                   List<Book> checkedOutBooks, Display display, List<Movie> movieList,
                   List<Movie> checkedoutMovieList, List<User> userList) {
        this.bookList = bookList;
        this.printStream = printStream;
        this.checkedOutBooks = checkedOutBooks;
        this.display = display;
        this.movieList = movieList;
        this.checkedoutMovieList = checkedoutMovieList;
        this.userList = userList;
    }

    public void displayBooks() {
        for (Book book : bookList) {
            printStream.println(book.getBookDetail());
        }
    }

    public void displayBooksWithBookNumber() {
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

    public void displayMoviesWithMovieNumber() {
        for (int i = 1; i <= movieList.size(); i++) {
            printStream.print(i + ". ");
            printStream.println(movieList.get(i - 1).getMovieDetail());
        }
    }

    public void checkoutMovie() {
        printStream.println("Which movie would you like to check out?");
        displayMoviesWithMovieNumber();
        String userInput = display.getUserInput();
        int index = Integer.parseInt(userInput) - 1;
        if (index >= 0 && index < movieList.size()) {
            Movie movie = movieList.remove(index);
            checkedoutMovieList.add(movie);
            printStream.println("Thank you! Enjoy your movie.");
        } else {
            printStream.println("That movie is not available.");
        }
    }

    public void displayCheckedoutMoviesWithMovieNumber() {
        for (int i = 1; i <= checkedoutMovieList.size(); i++) {
            printStream.print(i + ". ");
            printStream.println(checkedoutMovieList.get(i - 1).getMovieDetail());
        }
    }

    public void returnMovie() {
        printStream.println("Which movie would you want to return?");
        displayCheckedoutMoviesWithMovieNumber();
        String userInput = display.getUserInput();
        int index = Integer.parseInt(userInput) - 1;
        if (index >= 0 && index < checkedoutMovieList.size()) {
            Movie movie = checkedoutMovieList.remove(index);
            movieList.add(movie);
            printStream.println("Thank you for returning the movie.");
        } else {
            printStream.println("That is not a valid movie to return.");
        }
    }

    public int getUserLoginInfomation() {
        printStream.print("Please input your library_number:");
        String library_number = display.getUserInput();
        printStream.print("Please input your password:");
        String password = display.getUserInput();
        int index = findUsersByLibraryNumberAndPassword(library_number, password);
        return index;
    }

    public int findUsersByLibraryNumberAndPassword(String library_number, String password) {
        int i = 0;
        int index = -1;
        for (User user : userList) {
            if (user.checkCredentials(library_number, password)) {
                index = i;
            }
            i++;
        }
        return index;
    }

    public void displayUserInformation(int index) {
        printStream.println(userList.get(index).getUserDetail());
    }
}
