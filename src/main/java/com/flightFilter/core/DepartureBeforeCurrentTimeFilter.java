package com.flightFilter.core;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/*A filter that excludes departures before the current time.*/
public class DepartureBeforeCurrentTimeFilter implements FlightFiltering {

        @Override
        public List<Flight> flightFiltering(List<Flight> flights) {

            LocalDateTime localDateTime = LocalDateTime.now();

            return flights.stream().filter(flight -> flight.getSegments().stream().noneMatch(segment -> segment
                    .getDepartureDate().isBefore(localDateTime))).collect(Collectors.toList());
        }
}
























