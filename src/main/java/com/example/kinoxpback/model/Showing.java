package com.example.kinoxpback.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="showings")
public class Showing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="showing_id")
    private int showingId;

    @Column(name="show_date")
    private LocalDate showDate;

    @Column(name="show_time")
    private LocalTime showTime;

    private double price;

//    @ManyToOne
//    @JoinColumn(name="fk_movie_id", referencedColumnName = "movie_id")
//    private Movie movie;

    @ManyToOne
    @JoinColumn(name="fk_theater_id", referencedColumnName = "theater_id")
    private Theater theater;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
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

}
