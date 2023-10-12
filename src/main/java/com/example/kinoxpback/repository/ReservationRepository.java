package com.example.kinoxpback.repository;

import com.example.kinoxpback.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
