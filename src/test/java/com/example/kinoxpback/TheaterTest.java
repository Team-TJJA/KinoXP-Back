package com.example.kinoxpback;

import com.example.kinoxpback.enums.TheaterSize;
import com.example.kinoxpback.model.Theater;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TheaterTest {

    Theater cut;

    @Test
    public void theaterRowAndSeatSmall(){
        cut = new Theater();

        cut.setSize(TheaterSize.SMALL);

        int expectedNumberOfRows = 20;
        int expectedNumberOfSeatsPerRow = 12;

        assertEquals(expectedNumberOfRows, cut.getNumberOfRows());
        assertEquals(expectedNumberOfSeatsPerRow, cut.getNumberOfSeatsPerRow());
    }

    @Test
    public void theaterRowAndSeatLarge(){
        cut = new Theater();

        cut.setSize(TheaterSize.LARGE);

        int expectedNumberOfRows = 25;
        int expectedNumberOfSeatsPerRow = 16;

        assertEquals(expectedNumberOfRows, cut.getNumberOfRows());
        assertEquals(expectedNumberOfSeatsPerRow, cut.getNumberOfSeatsPerRow());
    }

}
