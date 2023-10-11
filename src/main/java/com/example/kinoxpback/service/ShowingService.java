package com.example.kinoxpback.service;

import com.example.kinoxpback.model.Showing;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ShowingService {

    List<Showing> getShowings();

    List<Showing> getShowings(LocalDate date);

    List<LocalDate> showingDatesEightDays();

    Optional<Showing> postShowing(Showing showing);

    Optional<Showing> putShowing(Showing showing);

    boolean deleteShowing(int id);

}
