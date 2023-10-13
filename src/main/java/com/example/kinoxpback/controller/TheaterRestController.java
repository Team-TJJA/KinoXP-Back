package com.example.kinoxpback.controller;

import com.example.kinoxpback.model.Seat;
import com.example.kinoxpback.model.Theater;
import com.example.kinoxpback.repository.TheaterRepository;
import com.example.kinoxpback.service.TheaterService;
import com.example.kinoxpback.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
public class TheaterRestController {

    @Autowired
    TheaterService theaterService;

    @Autowired
    TheaterRepository theaterRepository;

    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getTheaters() {
        List<Theater> theaters = theaterService.getTheaters();

        if (!theaters.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(theaters);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(theaters);
        }
    }

    @GetMapping("/theater/seats/{id}")
    public ResponseEntity<List<Seat>> getTheaterSeats(@PathVariable int id) {
        List<Seat> theaterSeats= theaterService.getTheaterSeats(id);

        if (!theaterSeats.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(theaterSeats);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(theaterSeats);
        }
    }


}