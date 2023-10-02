package com.example.kinoxpback.controller;

import com.example.kinoxpback.model.Showing;
import com.example.kinoxpback.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ShowingRestController {

    @Autowired
    ShowingService showingService;

    @GetMapping("/showings")
    public ResponseEntity<List<Showing>> getShowing() {
        List<Showing> showings = showingService.getShowings();

        if(showings.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(showings);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(showings);
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

    @PutMapping("/showings/{id}")
    public ResponseEntity<?> putShowing(@PathVariable int id, @RequestBody Showing showing) {
        Optional<Showing> showingUpdated = showingService.putShowing(id,showing);

        if(showingUpdated.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(showingUpdated.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SHOW NOT UPDATED");
        }
    }


    @DeleteMapping("/showings/delete/{id}")
    public ResponseEntity<String> deleteShowing(@PathVariable int id) {
        boolean showingDeleted = showingService.deleteShowing(id);

        if(showingDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("SHOW DELETED");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SHOW NOT DELETED");
        }
    }
}
