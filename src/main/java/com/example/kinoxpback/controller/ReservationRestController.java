package com.example.kinoxpback.controller;

import com.example.kinoxpback.model.Reservation;
import com.example.kinoxpback.model.DTO.ReservationSeatDTO;
import com.example.kinoxpback.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

    //GET
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = reservationService.getReservation();

        if(reservations.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reservations);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservations);
    }

    //POST
    @PostMapping("/reservations")
    public ResponseEntity<?> postReservation(@RequestBody Reservation reservation) {
        Optional<Reservation> reservationSaved = reservationService.postReservation(reservation);

        if(reservationSaved.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(reservationSaved.get());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("RESERVATION NOT SAVED.");
    }

    //PUT
    @PutMapping("/reservations")
    public ResponseEntity<?> putReservation() {
        return null;
    }

    //DELETE
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable int id) {
        boolean reservationFound = reservationService.deleteReservation(id);

        if(reservationFound) {
            return ResponseEntity.status(HttpStatus.OK).body("MOVIE DELETED");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MOVIE NOT DELETED");
    }

    //SHOWING ID getTakenSeats
    @GetMapping("/reservations/seats/{id}")
    public ResponseEntity<Set<ReservationSeatDTO>> getTakenSeats(@PathVariable int id) {
        Set<ReservationSeatDTO> reservationSeats = reservationService.getReservationsSeatsByShowingID(id);

        if(reservationSeats.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reservationSeats);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservationSeats);
    }
}

