package com.example.kinoxpback.repository;

import com.example.kinoxpback.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing,Integer> {
    @Query("SELECT s FROM Showing s WHERE s.showingDate = :date")
    List<Showing> getShowingsFromDate(@Param("date") Date date);

}
