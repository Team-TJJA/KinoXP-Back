package com.example.kinoxpback;

//import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.repository.MovieRepository;
import com.example.kinoxpback.service.Impl.MovieServiceImpl;
import com.example.kinoxpback.service.MovieService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieTest {

        MovieServiceImpl sut;

    @BeforeAll
    public void beforeAll() {
        sut = new MovieServiceImpl();
    }

    @BeforeEach
    public void beforeEach() {
    }

    public void createMovie() {
    }

    public void movieTestExistingMovies() {
        List<Movie> movies = sut.getMovies();
        assertTrue(!movies.isEmpty());
    }

}
