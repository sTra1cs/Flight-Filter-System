package com.flightFilter.core;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFiltering flightFiltering = new DepartureBeforeCurrentTimeFilter();
        FlightFiltering flightFiltering1 = new ArrivalDateIsEarlierThanDepartureDateFilter();
        FlightFiltering flightFiltering2 = new TimeOnGroundMoreThanTwoHoursFilter();


        System.out.println(flightFiltering.flightFiltering(flights));
        System.out.println();
        System.out.println(flightFiltering1.flightFiltering(flights));
        System.out.println();
        System.out.println(flightFiltering2.flightFiltering(flights));


        }
    }

