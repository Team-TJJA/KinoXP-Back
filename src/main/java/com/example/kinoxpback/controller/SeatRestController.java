package com.example.kinoxpback.controller;

import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.model.Seat;
import com.example.kinoxpback.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SeatRestController {
    @Autowired
    private SeatService seatService;

    /*------------------------------------------GET-------------------------------------------------------------------*/

    @GetMapping("/seat")
    public ResponseEntity<List<Seat>> getSeat() {
        List<Seat> seatList = seatService.getSeats();
        if (seatList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(seatList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(seatList);
        }
    }
}
