package com.example.kinoxpback.config;

import com.example.kinoxpback.enums.TheaterSize;
import com.example.kinoxpback.model.Seat;
import com.example.kinoxpback.model.Theater;
import com.example.kinoxpback.repository.SeatRepository;
import com.example.kinoxpback.repository.TheaterRepository;
import com.example.kinoxpback.service.Impl.TheaterServiceImpl;
import com.example.kinoxpback.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    TheaterService theaterService;

    @Override
    public void run(String... args) throws Exception {
        if (theaterRepository.findAll().isEmpty()) {
            createSmallTheater();
            createLargeTheater();
        }
    }

    private void createSmallTheater() {
        Theater theater = new Theater();
        theater.setSize(TheaterSize.SMALL);
        theaterRepository.save(theater);
        createSeats(theater);
    }

    private void createLargeTheater() {
        Theater theater = new Theater();
        theater.setSize(TheaterSize.LARGE);
        theaterRepository.save(theater);
        createSeats(theater);
    }

    private void createSeats(Theater theater) {
        int numberOfRows = theater.getNumberOfRows();
        int numberOfSeatsPerRow = theater.getNumberOfSeatsPerRow();
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= numberOfSeatsPerRow; j++) {
                Seat seat = new Seat();
                seat.setTheaterID(theater);
                seat.setRowNumber(i);
                seat.setSeatNumber(j);
                seatRepository.save(seat);
            }
        }
    }
}
