package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.model.Seat;
import com.example.kinoxpback.model.Theater;
import com.example.kinoxpback.repository.TheaterRepository;
import com.example.kinoxpback.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public List<Theater> getTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Optional<Theater> postTheater(Theater theater) {
        return Optional.of(theaterRepository.save(theater));
    }

    public Optional<Theater> putTheater(Theater theater) {
        Optional<Theater> theaterFound = theaterRepository.findById(theater.getTheaterID());

        if(theaterFound.isPresent()) {
            return Optional.of(theaterRepository.save(theater));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteTheater(int id) {
        Optional<Theater> theaterDeleted = theaterRepository.findById(id);

        if(theaterDeleted.isPresent()) {
            theaterRepository.delete(theaterDeleted.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Seat> getTheaterSeats(int id) {
        Optional<Theater> theater = theaterRepository.findById(id);
        return theater.get().getSeats();
    }
}
