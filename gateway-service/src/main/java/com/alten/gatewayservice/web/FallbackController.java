package com.alten.gatewayservice.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping(value = "/__fallback/pricing", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> pricingFallback() {
        return Mono.just("{\"message\":\"Pricing service temporarily unavailable\",\"fallback\":true}");
    }

    @GetMapping(value = "/__fallback/flights", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> flightsFallback() {
        return Mono.just("{\"message\":\"Flight service temporarily unavailable\",\"fallback\":true}");
    }
}
