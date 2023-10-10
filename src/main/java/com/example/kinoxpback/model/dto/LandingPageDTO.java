package com.example.kinoxpback.model.dto;

import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.model.Showing;
import com.example.kinoxpback.model.Theater;

public class LandingPageDTO {
    private Movie movie;
    private Showing showing;
    private Theater theater;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
