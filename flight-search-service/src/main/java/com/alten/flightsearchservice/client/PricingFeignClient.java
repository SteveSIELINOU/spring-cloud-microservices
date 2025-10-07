package com.alten.flightsearchservice.client;

import com.alten.flightsearchservice.domain.dto.PricingQuote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "pricing-service", path = "/api/pricing")
public interface PricingFeignClient {

    @GetMapping("/quote")
    PricingQuote quote(
            @RequestParam("baseFare") BigDecimal baseFare,
            @RequestParam("currency") String currency,
            @RequestParam("bags") int bags
    );
}