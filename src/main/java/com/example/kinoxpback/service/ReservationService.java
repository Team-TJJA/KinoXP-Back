package com.example.kinoxpback.service;

import com.example.kinoxpback.model.Reservation;
import com.example.kinoxpback.model.DTO.ReservationSeatDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ReservationService {

    List<Reservation> getReservation();

    Optional<Reservation> postReservation(Reservation reservation);

    Optional<Reservation> putReservation(Reservation reservation);

    boolean deleteReservation(int id);

    Set<ReservationSeatDTO> getReservationsSeatsByShowingID(int id);

}
