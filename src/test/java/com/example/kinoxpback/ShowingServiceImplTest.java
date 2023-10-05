package com.example.kinoxpback;

import com.example.kinoxpback.model.Showing;
import com.example.kinoxpback.service.Impl.ShowingServiceImpl;
import com.example.kinoxpback.service.ShowingService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShowingServiceImplTest {

    /*
    static ShowingServiceImpl showingServiceImpl;
    static Showing showing;

    @BeforeAll
    static void setup() {
        showing = new Showing();
        showingServiceImpl = new ShowingServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({"2023-08-10, 12:00:00", "2050-01-01, 06:30:00"})
    public void testingShowingObjectPersistenceToDatabase(String dateString, String timeString) {
        //Arrange
        LocalDate date = LocalDate.parse(dateString);
        LocalTime time = LocalTime.parse(timeString);

        showing = new Showing();
        showing.setShowDate(date);
        showing.setShowTime(time);

        // Act
        Optional<Showing> result = showingServiceImpl.postShowing(showing);

        // Assert
        Assertions.assertTrue(result.isPresent());
    }


    @Test
    public void testingShowingObjectRetrievalFromDatabase() {
        //Act
        List<Showing> showingsResult = showingServiceImpl.getShowings();

        //Assert
        Assertions.assertEquals(2,showingsResult.size());
    }
    */
}
