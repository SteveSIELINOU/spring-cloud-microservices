package com.alten.flightsearchservice.service;

import com.alten.flightsearchservice.client.PricingFeignClient;
import com.alten.flightsearchservice.client.PricingServiceClient;
import com.alten.flightsearchservice.domain.Flight;
import com.alten.flightsearchservice.domain.dto.PricingQuote;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PricingService implements PricingServiceClient {

    private final PricingFeignClient pricingClient;

    @Override
    @CircuitBreaker(name = "pricing-service", fallbackMethod = "fallbackQuoteForFlight")
    public PricingQuote getQuoteForFlight(Flight f, int bags) {
        return pricingClient.quote(f.getBaseFare(), f.getCurrency(), bags);
    }

    public PricingQuote fallbackQuoteForFlight(Flight f, int bags, Throwable t) {
        BigDecimal base = f.getBaseFare() != null ? f.getBaseFare() : BigDecimal.ZERO;
        String curr = f.getCurrency() != null ? f.getCurrency() : "EUR";
        return new PricingQuote(base, BigDecimal.ZERO, BigDecimal.ZERO, base, curr, bags);
    }
}