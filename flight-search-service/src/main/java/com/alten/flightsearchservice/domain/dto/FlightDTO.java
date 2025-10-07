package com.alten.flightsearchservice.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FlightDTO {

    private Long id;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private String airline;
    private String flightNumber;
    private String cabin;
    private Integer seatsAvailable;
    private String currency;

    private PricingQuote pricingQuote;
}