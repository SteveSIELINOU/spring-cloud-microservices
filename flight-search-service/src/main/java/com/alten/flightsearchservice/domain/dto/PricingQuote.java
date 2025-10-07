package com.alten.flightsearchservice.domain.dto;

import java.math.BigDecimal;

public record PricingQuote(
        BigDecimal baseFare,
        BigDecimal tax,
        BigDecimal bagFees,
        BigDecimal total,
        String currency,
        int bags
) {}
