package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.model.Showing;
import com.example.kinoxpback.repository.ShowingRepository;
import com.example.kinoxpback.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ShowingServiceImpl implements ShowingService {

    @Autowired
    private ShowingRepository showingRepository;

    @Override
    public List<Showing> getShowings() {
        return showingRepository.findAll();
    }

    @Override
    public List<Showing> getShowings(LocalDate date) {
        return showingRepository.findByShowingDate(date);
    }

    @Override
    public List<LocalDate> showingDatesEightDays() {
        return showingRepository.showingDatesEightDays();
    }

    @Override
    public Optional<Showing> postShowing(Showing showing) {
        return Optional.of(showingRepository.save(showing));
    }

    public Optional<Showing> putShowing(Showing showing) {
        Optional<Showing> showingFound = showingRepository.findById(showing.getShowingID());
        if(showingFound.isPresent()) {
            return Optional.of(showingRepository.save(showing));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public boolean deleteShowing(int id) {
        Optional<Showing> showingDeleted = showingRepository.findById(id);

        if(showingDeleted.isPresent()) {
            showingRepository.delete(showingDeleted.get());
            return true;
        }
        return false;
    }
}
