package com.flightFilter.core;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/*A filter that eliminates time spent on the ground for more than two hours.*/

public class TimeOnGroundMoreThanTwoHoursFilter implements FlightFiltering {
    @Override
    public List<Flight> flightFiltering(List<Flight> flights) {

        List <Flight> filteredFlights = new ArrayList<>();

        for(Flight flight: flights){

            List<Segment> segments = flight.getSegments();
            boolean validFlight = true;

            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime localDateTime1 = segments.get(i).getArrivalDate();
                LocalDateTime localDateTime2 = segments.get(i+1).getDepartureDate();

                Duration duration = Duration.between(localDateTime1,localDateTime2);
                long minutes = duration.toMinutes();
                if(minutes > 120){
                    validFlight = false;
                    break;
                }
            }
            if(validFlight){
                filteredFlights.add(flight);
            }
        }

        return filteredFlights;
    }
}
