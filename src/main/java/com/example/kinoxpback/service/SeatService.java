package com.example.kinoxpback.service;

import com.example.kinoxpback.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<Seat> getSeats();
    Optional<Seat> getSeat(int id);
}
