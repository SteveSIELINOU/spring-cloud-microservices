package com.alten.bookingservice.web;

import com.alten.bookingservice.metrics.BookingMetrics;
import com.alten.bookingservice.model.BookingRequest;
import com.alten.bookingservice.model.BookingResponse;
import com.alten.bookingservice.repository.BookingRepository;
import com.alten.bookingservice.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;
    private final BookingRepository repo;
    private final BookingMetrics bookingMetrics;

    @PostMapping
    public ResponseEntity<BookingResponse> create(@Valid @RequestBody BookingRequest request) {
        bookingMetrics.increment();
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{recordLocator}")
    public ResponseEntity<?> byLocator(@PathVariable String recordLocator) {
        bookingMetrics.increment();
        return repo.findByRecordLocator(recordLocator)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}