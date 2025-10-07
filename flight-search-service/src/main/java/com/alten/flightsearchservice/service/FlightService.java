package com.alten.flightsearchservice.service;

import com.alten.flightsearchservice.client.FlightServiceClient;
import com.alten.flightsearchservice.client.PricingServiceClient;
import com.alten.flightsearchservice.domain.Flight;
import com.alten.flightsearchservice.domain.dto.FlightDTO;
import com.alten.flightsearchservice.mapper.FlightMapper;
import com.alten.flightsearchservice.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService implements FlightServiceClient {

  private final FlightRepository repository;
    private final PricingServiceClient pricing;

  public List<Flight> listAll() { return repository.findAll(); }

    private List<Flight> search(String origin, String destination, LocalDate dateFrom, LocalDate dateTo) {
        String o = origin == null ? null : origin.trim();
        String d = destination == null ? null : destination.trim();

        if (o == null || !StringUtils.hasText(o) || d == null || !StringUtils.hasText(d)) {
            throw new IllegalArgumentException("origin and destination are required");
        }
        if (dateFrom == null || dateTo == null || dateFrom.isAfter(dateTo)) {
            throw new IllegalArgumentException("dateFrom must be <= dateTo");
        }

        return repository.findByOriginIgnoreCaseAndDestinationIgnoreCaseAndDepartureDateBetween(
                o, d, dateFrom, dateTo
        );
    }

    public List<FlightDTO> searchWithQuotes(String origin, String destination, LocalDate from, LocalDate to, int bags) {
        List<Flight> flights = search(origin, destination, from, to);
        return flights.stream()
                .map(f -> FlightMapper.toDTO(f, pricing.getQuoteForFlight(f, bags)))
                .collect(Collectors.toList());
    }
}
