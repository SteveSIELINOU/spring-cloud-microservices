package com.alten.flightsearchservice.client;

import com.alten.flightsearchservice.domain.Flight;
import com.alten.flightsearchservice.domain.dto.FlightDTO;
import java.time.LocalDate;
import java.util.List;

public interface FlightServiceClient {
    List<Flight> listAll();
    List<FlightDTO> searchWithQuotes(String origin, String destination, LocalDate from, LocalDate to, int bags);
}

