package com.example.kinoxpback.controller;

import com.example.kinoxpback.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class LandingPageRestController {

    @Autowired
    LandingPageService landingPageService;

    @GetMapping("/showingdateseightdays")
    public ResponseEntity<List<LocalDate>> showingDatesEightDays(){
        List<LocalDate> showings = landingPageService.showingDatesEightDays();

        if(!showings.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(showings);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(showings);
        }
    }
}
