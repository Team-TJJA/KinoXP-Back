package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.repository.MovieRepository;
import com.example.kinoxpback.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> postMovie(Movie movie) {
        return Optional.of(movieRepository.save(movie));
    }

    @Override
    public Optional<Movie> putMovie(Movie movie) {

        Optional<Movie> movieFound = movieRepository.findById(movie.getMovieID());

        if (movieFound.isPresent()){
            return Optional.of(movieRepository.save(movie));
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteMovie(int id) {

        Optional<Movie> movieFound = movieRepository.findById(id);

        if (movieFound.isPresent()){
            movieRepository.delete(movieFound.get());
            return true;
        }

        return false;
    }


}
