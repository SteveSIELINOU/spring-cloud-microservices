package com.alten.flightsearchservice.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class FlightSearchMetrics {
    private final Counter searchCounter;
    public FlightSearchMetrics(MeterRegistry registry) {
        this.searchCounter = Counter.builder("flight_search_total")
                .description("Total number of flight searches performed")
                .tag("service","flight-search-service")
                .register(registry);
    }
    public void increment() { searchCounter.increment(); }
}