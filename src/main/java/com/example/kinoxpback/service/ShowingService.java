package com.example.kinoxpback.service;

import com.example.kinoxpback.model.Showing;

import java.util.List;
import java.util.Optional;

public interface ShowingService {

    List<Showing> getShowings();

    Optional<Showing> postShowing(Showing showing);

    Optional<Showing> putShowing(int id, Showing showing);

    boolean deleteShowing(int id);

}
