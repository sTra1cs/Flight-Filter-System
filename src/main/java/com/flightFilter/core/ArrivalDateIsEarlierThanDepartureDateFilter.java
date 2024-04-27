package com.flightFilter.core;

import java.util.List;
import java.util.stream.Collectors;

/*A filter that excludes segments with an arrival date earlier than the departure date.*/

public class ArrivalDateIsEarlierThanDepartureDateFilter implements FlightFiltering {
    @Override
    public List<Flight> flightFiltering(List<Flight> flights) {

        return flights.stream().filter(flight -> flight.getSegments().stream()
                .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))).collect(Collectors.toList());
    }
}
