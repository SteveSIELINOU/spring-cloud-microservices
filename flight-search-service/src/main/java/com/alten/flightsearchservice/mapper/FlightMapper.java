package com.alten.flightsearchservice.mapper;

import com.alten.flightsearchservice.domain.Flight;
import com.alten.flightsearchservice.domain.dto.FlightDTO;
import com.alten.flightsearchservice.domain.dto.PricingQuote;

public class FlightMapper {

    public static FlightDTO toDTO(Flight flight, PricingQuote quote) {
        if (flight == null) return null;

        return FlightDTO.builder()
                .id(flight.getId())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .departureDate(flight.getDepartureDate())
                .returnDate(flight.getReturnDate())
                .airline(flight.getAirline())
                .flightNumber(flight.getFlightNumber())
                .cabin(flight.getCabin())
                .seatsAvailable(flight.getSeatsAvailable())
                .currency(flight.getCurrency())
                .pricingQuote(quote)
                .build();
    }
}
