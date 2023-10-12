package com.example.kinoxpback.service;

import com.example.kinoxpback.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getReservation();

    Optional<Reservation> postReservation(Reservation reservation);

    Optional<Reservation> putReservation(Reservation reservation);

    boolean deleteReservation(int id);
}
