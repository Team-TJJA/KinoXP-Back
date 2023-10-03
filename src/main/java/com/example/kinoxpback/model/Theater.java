package com.example.kinoxpback.model;

import com.example.kinoxpback.enums.TheaterSize;
import jakarta.persistence.*;

@Entity
public class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theater_id")
    private int theaterID;
    private TheaterSize size;
    private int numberOfRows;
    private int numberOfSeatsPerRow;

    public Theater() {
    }

    public Theater(TheaterSize size) {
        this.size = size;
        switch(size){
            case SMALL:
                numberOfRows = 20;
                numberOfSeatsPerRow = 12;
                break;

            case LARGE:
                numberOfRows = 25;
                numberOfSeatsPerRow = 16;
                break;
        }
    }

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
