package com.example.kinoxpback.service;

import com.example.kinoxpback.model.Theater;

import java.util.List;
import java.util.Optional;

public interface TheaterService {
    List<Theater> getTheaters();

    Optional<Theater> postTheater(Theater theater);

    Optional<Theater> putTheater(Theater theater);

    boolean deleteTheater(int id);
}
