package com.alten.flightsearchservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 8)
  private String origin;

  @Column(nullable = false, length = 8)
  private String destination;

  @Column(name = "departure_date", nullable = false)
  private LocalDate departureDate;

  @Column(name = "return_date")
  private LocalDate returnDate;

  @Column(nullable = false, length = 2)
  private String airline;

  @Column(name = "flight_number", nullable = false, length = 10)
  private String flightNumber;

  @Column(nullable = false, length = 16)
  private String cabin;

  @Column(name = "base_fare", nullable = false, precision = 12, scale = 2)
  private BigDecimal baseFare;

  @Column(name = "total_fare", nullable = false, precision = 12, scale = 2)
  private BigDecimal totalFare;

  @Column(nullable = false, length = 3)
  private String currency;

  @Column(name = "seats_available", nullable = false)
  private Integer seatsAvailable;
}
