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
                checkedoutBookList(), display, movieList(), checkedoutMovieList(),
                userList());
        Menu menu = new Menu(library, printStream, display);
        int index = library.getUserLoginInfomation();
        while (index == -1) {
            printStream.println("Your have incorrect input,please input again!");
            index = library.getUserLoginInfomation();
        }
        menu.selectOption(index);
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

    public static List<Movie> movieList() {
        List<Movie> movieList = new ArrayList<Movie>();
        Movie movie1 = new Movie("movie1 name", "2001", "movie1 director", 3);
        Movie movie2 = new Movie("movie2 name", "2002", "movie2 director", 9);
        movieList.add(movie1);
        movieList.add(movie2);

        return movieList;
    }

    public static List<Movie> checkedoutMovieList() {
        List<Movie> checkedoutMovieList = new ArrayList<Movie>();
        Movie checkedoutMovie1 = new Movie("checkedoutMovie1 name", "2001", "checkedoutMovie1 director", 2);
        Movie checkedoutMovie2 = new Movie("checkedoutMovie2 name", "2002", "checkedoutMovie2 director", 7);
        checkedoutMovieList.add(checkedoutMovie1);
        checkedoutMovieList.add(checkedoutMovie2);

        return checkedoutMovieList;
    }

    public static List<User> userList() {
        List<User> userList = new ArrayList<User>();
        User user1 = new User("name1", "name1@name1.com", "13311111111", "133-1111", "1111");
        User user2 = new User("name2", "name2@name2.com", "13322222222", "133-2222", "2222");
        User user3 = new User("name3", "name3@name3.com", "13333333333", "133-3333", "3333");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
}
