package com.example.kinoxpback.controller;

import com.example.kinoxpback.model.Showing;
import com.example.kinoxpback.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ShowingRestController {

    @Autowired
    ShowingService showingService;

    @GetMapping("/showings")
    public ResponseEntity<List<Showing>> getShowings() {
        List<Showing> showings = showingService.getShowings();

        if(!showings.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(showings);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(showings);
        }
    }

    @GetMapping("/showings/{date}")
    public ResponseEntity<List<Showing>> getShowings(@PathVariable LocalDate date){
        List<Showing> showings = showingService.getShowings(date);

        if(!showings.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(showings);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(showings);
        }
    }
    @GetMapping("/showings/week")
    public ResponseEntity<List<LocalDate>> showingDatesEightDays(){
        List<LocalDate> showingDates = showingService.showingDatesEightDays();

        if(!showingDates.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(showingDates);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(showingDates);
        }
    }

    @PostMapping("/showings")
    public ResponseEntity<?> postShowing(@RequestBody Showing showing) {
        Optional<Showing> showingSaved = showingService.postShowing(showing);

        if(showingSaved.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(showingSaved.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SHOW NOT SAVED");
        }
    }

    @PutMapping("/showings")
    public ResponseEntity<?> putShowing(@RequestBody Showing showing) {
        Optional<Showing> showingUpdated = showingService.putShowing(showing);

        if(showingUpdated.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(showingUpdated.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SHOW NOT UPDATED");
        }
    }


    @DeleteMapping("/showings/{id}")
    public ResponseEntity<String> deleteShowing(@PathVariable int id) {
        boolean showingDeleted = showingService.deleteShowing(id);

        if(showingDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("SHOW DELETED");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SHOW NOT DELETED");
        }
    }
}
