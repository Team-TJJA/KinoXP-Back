package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.repository.MovieRepository;
import com.example.kinoxpback.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
