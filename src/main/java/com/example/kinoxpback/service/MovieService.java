package com.example.kinoxpback.service;

import com.example.kinoxpback.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getMovies();
    Optional<Movie> postMovie(Movie movie);

    Optional<Movie> putMovie(Movie movie);

    boolean deleteMovie(int id);
}

