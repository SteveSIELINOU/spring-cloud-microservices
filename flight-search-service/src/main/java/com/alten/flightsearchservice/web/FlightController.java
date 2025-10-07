package com.alten.flightsearchservice.web;

import com.alten.flightsearchservice.client.FlightServiceClient;
import com.alten.flightsearchservice.domain.Flight;
import com.alten.flightsearchservice.domain.dto.FlightDTO;
import com.alten.flightsearchservice.metrics.FlightSearchMetrics;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightServiceClient flightService;
    private final FlightSearchMetrics flightSearchMetrics;

    @GetMapping
    public ResponseEntity<List<Flight>> listAll() {
        flightSearchMetrics.increment();
        return ResponseEntity.ok(flightService.listAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> search(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo,
            @RequestParam(defaultValue = "0") int bags
    ) {
        flightSearchMetrics.increment();
        return ResponseEntity.ok(flightService.searchWithQuotes(origin, destination, dateFrom, dateTo, bags));
    }
}
