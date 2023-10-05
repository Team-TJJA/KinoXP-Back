package com.example.kinoxpback.controller;

import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MovieRestController {

    /*------------------------------------------INSTANCES-------------------------------------------------------------*/

    @Autowired
    private MovieService movieService;

    /*------------------------------------------GET-------------------------------------------------------------------*/

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movieList = movieService.getMovies();

        if (movieList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movieList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(movieList);
        }
    }

    /*-------------------------------------------------POST-----------------------------------------------------------*/

    @PostMapping("/movies")
    public ResponseEntity<?> postMovie(@RequestBody Movie movie){
        Optional<Movie> movieSaved = movieService.postMovie(movie);

        if (movieSaved.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("MOVIE NOT SAVED");
        }
    }

    /*-------------------------------------------------PUT------------------------------------------------------------*/

    @PutMapping("/movies")
    public ResponseEntity<?> putMovie(@RequestBody Movie movie){
        Optional<Movie> movieFound = movieService.putMovie(movie);

        if (movieFound.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MOVIE NOT UPDATED");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(movieFound);
        }
    }

    /*-------------------------------------------------DELETE---------------------------------------------------------*/

    @DeleteMapping("/movies/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        Boolean movieFound = movieService.deleteMovie(id);

        if (movieFound){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MOVIE DELETED");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("MOVIE NOT DELETED");
        }
    }

}
