package com.example.kinoxpback.repository;

import com.example.kinoxpback.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing,Integer> {
    @Query("SELECT s.showingDate FROM Showing s WHERE s.showingDate >= CURRENT_DATE AND s.showingDate <= CURRENT_DATE + 7")
    List<LocalDate> showingDatesEightDays();
}
