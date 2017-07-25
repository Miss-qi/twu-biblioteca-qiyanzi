package com.twu.biblioteca;

public class Movie {
    private String movieName;
    private String year;
    private String director;
    private int rating;

    public Movie(String movieName, String year, String director, int rating) {
        this.movieName = movieName;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public String getMovieDetail() {
        return String.format("movieName:%-4s year:%-4s director:%-4s rating:%d", movieName, year, director, rating);
    }
}

