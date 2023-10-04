package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.model.Movie;
import com.example.kinoxpback.model.Seat;
import com.example.kinoxpback.repository.SeatRepository;
import com.example.kinoxpback.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Optional<Seat> getSeat(int id) {
        return seatRepository.findById(id);
    }
}
