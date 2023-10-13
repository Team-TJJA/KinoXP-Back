package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.model.Reservation;
import com.example.kinoxpback.model.DTO.ReservationSeatDTO;
import com.example.kinoxpback.repository.ReservationRepository;
import com.example.kinoxpback.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
            reservationRepository.delete(reservationFound.get());
            return true;
        }
        return false;
    }

    @Override
    public Set<ReservationSeatDTO> getReservationsSeatsByShowingID(int id) {
        Set<Object[]> result = reservationRepository.getReservationSeatsByShowingId(id);

        Set<ReservationSeatDTO> seats = new HashSet<>();
        for (Object[] row : result) {
            ReservationSeatDTO seat = new ReservationSeatDTO();

            seat.setRowNumber((Integer) row[1]);

            seat.setSeatID((Integer) row[2]);

            seat.setSeatNumber((Integer) row[3]);

            seats.add(seat);
        }

        return seats;
    }
}
