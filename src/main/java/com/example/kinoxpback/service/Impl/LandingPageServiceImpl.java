package com.example.kinoxpback.service.Impl;

import com.example.kinoxpback.repository.MovieRepository;
import com.example.kinoxpback.repository.ShowingRepository;
import com.example.kinoxpback.repository.TheaterRepository;
import com.example.kinoxpback.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LandingPageServiceImpl implements LandingPageService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowingRepository showingRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public List<LocalDate> showingDatesEightDays() {
        return showingRepository.showingDatesEightDays();
    }




}
