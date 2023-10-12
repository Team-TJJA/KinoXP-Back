package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.model.Reservation;
import com.example.kinoxpback.repository.ReservationRepository;
import com.example.kinoxpback.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> postReservation(Reservation reservation) {
        return Optional.of(reservationRepository.save(reservation));
    }

    @Override
    public Optional<Reservation> putReservation(Reservation reservation) {
        Optional<Reservation> reservationFound = reservationRepository.findById(reservation.getReservationID());
        if(reservationFound.isPresent()) {
            return Optional.of(reservationRepository.save(reservation));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteReservation(int id) {
        Optional<Reservation> reservationFound = reservationRepository.findById(id);
        if(reservationFound.isPresent()) {
            return true;
        }
        return false;
    }
}
