package com.example.kinoxpback.model;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seat_id")
    private int seatID;
    @ManyToOne
    @JoinColumn(name="fk_theater_id", referencedColumnName = "theater_id")
    private Theater theaterID;
    @Column(name="row_number")
    private int rowNumber;
    @Column(name="seat_number")
    private int seatNumber;

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public Theater getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Theater theaterID) {
        this.theaterID = theaterID;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
