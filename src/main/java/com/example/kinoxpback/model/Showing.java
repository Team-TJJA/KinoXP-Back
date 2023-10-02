package com.example.kinoxpback.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="showings")
public class Showing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(name="show_date")
    private LocalDate showDate;

    @Column(name="show_time")
    private LocalTime showTime;

    // Classes not made yet
    /*
    @ManyToOne
    @JoinColumn(name="fk_movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="fk_theater_id", referencedColumnName = "theater_id")
    private Theater theater;

     */
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    //Classes not made yet
    /*
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

     */
}
