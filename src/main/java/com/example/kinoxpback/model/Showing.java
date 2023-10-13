package com.example.kinoxpback.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name="showings")
public class Showing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="showing_id")
    private int showingID;

    @Column(name="showing_date")
    private LocalDate showingDate;

    @Column(name="showing_time")
    private LocalTime showingTime;

    @Column(name="price")
    private double price;

   @ManyToOne
    @JoinColumn(name="fk_movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="fk_theater_id", referencedColumnName = "theater_id")
    private Theater theater;

    @OneToMany(mappedBy = "showing")
    @JsonBackReference
    private Set<Reservation> reservations;

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

    public int getShowingID() {
        return showingID;
    }

    public void setShowingID(int showingId) {
        this.showingID = showingId;
    }

    public LocalDate getShowDate() {
        return showingDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showingDate = showDate;
    }

    public LocalTime getShowTime() {
        return showingTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showingTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
