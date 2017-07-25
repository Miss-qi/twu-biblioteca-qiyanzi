package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String publishDate;

    public Book(String title, String author, String publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getBookDetail() {
        return String.format("title:%-4s author:%-4s publishDate:%-4s", title, author, publishDate);
    }
}
