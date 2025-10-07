INSERT INTO bookings
(record_locator, flight_number, origin, destination, departure_date,
 seat_count, person_type, total_fare, currency)
VALUES
    ('AB12CD34', 'AZ0123', 'FCO', 'CDG', DATE '2025-11-20', 2, 'ADULT', 249.99, 'EUR'),
    ('EF56GH78', 'LH9876', 'MXP', 'FRA', DATE '2025-12-05', 1, 'ADULT', 179.50, 'EUR'),
    ('JK90LM12', 'AF4510', 'CDG', 'JFK', DATE '2025-12-22', 3, 'CHILD',  999.00, 'EUR');
