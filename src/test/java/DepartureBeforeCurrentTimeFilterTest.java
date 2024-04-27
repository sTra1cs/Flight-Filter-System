import com.flightFilter.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class DepartureBeforeCurrentTimeFilterTest {

    @Test
    void departureBeforeCurrentTimeTest() {
        DepartureBeforeCurrentTimeFilter filter =
                new DepartureBeforeCurrentTimeFilter();
        LocalDateTime now = LocalDateTime.now();

        Flight beforeCurrentTime = new Flight(Arrays.asList(new Segment(now.minusHours(7), now.minusHours(2))));
        Flight afterCurrentTime = new Flight(Arrays.asList(new Segment(now.plusHours(5), now.plusHours(8))));

        List<Flight> flights = Arrays.asList(beforeCurrentTime, afterCurrentTime);
        List<Flight> flightFiltering = new DepartureBeforeCurrentTimeFilter().flightFiltering(flights);

        Assertions.assertTrue(flightFiltering.contains(afterCurrentTime));
        Assertions.assertFalse(flightFiltering.contains(beforeCurrentTime));
    }

    @Test
    void ArrivalDateIsEarlierThanDepartureDateTest () {
        ArrivalDateIsEarlierThanDepartureDateFilter filter =
                new ArrivalDateIsEarlierThanDepartureDateFilter();
        LocalDateTime now = LocalDateTime.now();


        Flight correctFlight = new Flight(Arrays.asList(new Segment(now.plusHours(5), now.plusHours(7))));
        Flight incorrectFlight = new Flight(Arrays.asList(new Segment(now.plusHours(6), now.plusHours(5))));

        List<Flight> flights = Arrays.asList(correctFlight, incorrectFlight);
        List<Flight> filteredFlights = filter.flightFiltering(flights);

        Assertions.assertTrue(filteredFlights.contains(correctFlight));
        Assertions.assertFalse(filteredFlights.contains(incorrectFlight));
    }

    @Test

        void timeOnTheGroundMoreThanTwoHoursTest() {
            TimeOnGroundMoreThanTwoHoursFilter filter =
                    new TimeOnGroundMoreThanTwoHoursFilter();
            LocalDateTime now = LocalDateTime.now();


            Flight validFlight = new Flight(Arrays.asList(
                    new Segment(now, now.plusHours(2)),
                    new Segment(now.plusHours(3), now.plusHours(5))
            ));


            Flight invalidFlight = new Flight(Arrays.asList(
                    new Segment(now, now.plusHours(2)),
                    new Segment(now.plusHours(5), now.plusHours(7))
            ));

            List<Flight> flights = Arrays.asList(validFlight, invalidFlight);
            List<Flight> filteredFlights = filter.flightFiltering(flights);


            Assertions.assertTrue(filteredFlights.contains(validFlight));
            Assertions.assertFalse(filteredFlights.contains(invalidFlight));
        }
    }
