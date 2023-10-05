package com.example.kinoxpback.controller;

import com.example.kinoxpback.model.Theater;
import com.example.kinoxpback.service.TheaterService;
import com.example.kinoxpback.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TheaterRestController {

    @Autowired
    TheaterService theaterService;

    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getTheaters() {
        List<Theater> theaters = theaterService.getTheaters();

        if (!theaters.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(theaters);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(theaters);
        }
    }
}