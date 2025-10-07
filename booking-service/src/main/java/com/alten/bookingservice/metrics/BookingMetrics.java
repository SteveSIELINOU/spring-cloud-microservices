package com.alten.bookingservice.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class BookingMetrics {
    private final Counter createdCounter;
    public BookingMetrics(MeterRegistry registry) {
        this.createdCounter = Counter.builder("booking_created_total")
                .description("Number of bookings successfully created")
                .tag("service","booking-service")
                .register(registry);
    }
    public void increment() { createdCounter.increment(); }
}
