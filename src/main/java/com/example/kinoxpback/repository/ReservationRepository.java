package com.example.kinoxpback.repository;

import com.example.kinoxpback.model.Reservation;
import com.example.kinoxpback.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query(value = "SELECT s.* FROM seats s " +
            "WHERE s.seat_id IN " +
            "(SELECT rs.seat_id FROM reservations_seats rs " +
            "WHERE rs.reservation_id IN " +
            "(SELECT r.reservation_id FROM reservations r WHERE r.showing_id_fk = :showingId))", nativeQuery = true)
    Set<Object[]> getReservationSeatsByShowingId(@Param("showingId") Integer showingId);


}
