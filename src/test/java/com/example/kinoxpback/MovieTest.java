package com.example.kinoxpback;

import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.repository.MovieRepository;
import com.example.kinoxpback.service.Impl.MovieServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieTest {

    /*
    MovieServiceImpl sut;

    @BeforeAll
    public void beforeAll() {
        sut = new MovieServiceImpl();
    }

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    public void movieTestExistingMovies() {
        List<Movie> movies = sut.getMovies();
        assertTrue(!movies.isEmpty());
    }
     */

}
