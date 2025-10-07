package com.alten.flightsearchservice.client;

import com.alten.flightsearchservice.domain.Flight;
import com.alten.flightsearchservice.domain.dto.PricingQuote;

public interface PricingServiceClient {
    PricingQuote getQuoteForFlight(Flight f, int bags);
}
