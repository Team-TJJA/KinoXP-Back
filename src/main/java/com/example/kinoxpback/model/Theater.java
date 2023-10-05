package com.example.kinoxpback.model;

import com.example.kinoxpback.enums.TheaterSize;
import jakarta.persistence.*;

@Entity
public class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theater_id")
    private int theaterID;
    @Enumerated(EnumType.STRING)
    private TheaterSize size;

    @Column(name="number_of_rows")
    private int numberOfRows;

    @Column(name="number_of_seats_per_row")
    private int numberOfSeatsPerRow;

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public TheaterSize getSize() {
        return size;
    }

    public void setSize(TheaterSize size) {
        this.size = size;
        switch (size) {
            case SMALL -> {
                numberOfRows = 20;
                numberOfSeatsPerRow = 12;
            }
            case LARGE -> {
                numberOfRows = 25;
                numberOfSeatsPerRow = 16;
            }
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfSeatsPerRow() {
        return numberOfSeatsPerRow;
    }

    public void setNumberOfSeatsPerRow(int numberOfSeatsPerRow) {
        this.numberOfSeatsPerRow = numberOfSeatsPerRow;
    }
}
