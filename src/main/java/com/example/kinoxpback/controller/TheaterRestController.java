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

    @GetMapping("/Theaters")
    public ResponseEntity<List<Theater>> getTheater() {
        List<Theater> theaters = theaterService.getTheaters();

        if (!theaters.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(theaters);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(theaters);
        }
    }

    @PostMapping("/theaters")
    public ResponseEntity<?> postTheater(@RequestBody Theater theater) {
        Optional<Theater> theaterSaved = theaterService.postTheater(theater);

        if (theaterSaved.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(theaterSaved.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SHOW NOT SAVED");
        }
    }

    @PutMapping("/theaters")
    public ResponseEntity<?> putTheater(@RequestBody Theater theater) {
        Optional<Theater> theaterUpdated = theaterService.putTheater(theater);

        if (theaterUpdated.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(theaterUpdated.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SHOW NOT UPDATED");
        }
    }


    @DeleteMapping("/theaters/delete/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable int id) {
        boolean theaterDeleted = theaterService.deleteTheater(id);

        if (theaterDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("SHOW DELETED");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SHOW NOT DELETED");
        }
    }
}